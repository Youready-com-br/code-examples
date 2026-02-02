package br.com.youready.miniaulafev26.wellthought;

import br.com.youready.miniaulafev26.*;
import br.com.youready.miniaulafev26.original.OrderRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderServiceWellThought {

    private static final Logger log =
            LoggerFactory.getLogger(OrderServiceWellThought.class);

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final InventoryEventPublisher eventPublisher;

    public OrderResponse placeOrder(OrderRequestWellThought request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID()
                                 .toString());
        order.setCustomerEmail(request.customerEmail());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);

        BigDecimal totalAmount = BigDecimal.ZERO;

        for (var itemRequest : request.items()) {
            Product product =
                    productRepository
                            .findById(itemRequest.productId())
                            .orElseThrow(
                                    () ->
                                            new BusinessRuleException(
                                                    "Product not found " + "with id: " + itemRequest.productId()));

            product.validateStockQuantity(itemRequest.quantity());

            int quantity = itemRequest.quantity();
            BigDecimal unitPrice = product.getPrice();

            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(quantity);
            orderItem.setUnitPrice(unitPrice);
            order.addItem(orderItem);

            totalAmount =
                    totalAmount.add(unitPrice.multiply(BigDecimal.valueOf(quantity)));

            int newStock = product.getStockQuantity() - quantity;
            product.setStockQuantity(newStock);
            productRepository.save(product);
            eventPublisher.publishStockUpdated(new StockUpdate(product.getId(), newStock));
        }

        // Free shipping
        //Antes: if (totalAmount.compareTo(new BigDecimal("100")) > 0) {
        // Existe um conceito claro e bem localizado sobre a regra de frete.
        if (ShippingPolicy.applyFreeShipping(totalAmount, request.isVip())) {
            order.setFreeShipping(true);
            log.info("Order {} qualifies for free shipping.",
                    order.getOrderNumber());
        }

        // Manual review
        if (totalAmount.compareTo(new BigDecimal("500")) > 0) {
            order.setManualReview(true);
            log.warn("Order {} requires manual review.",
                    order.getOrderNumber());
        }

        order.setTotalAmount(totalAmount);
        Order savedOrder = orderRepository.save(order);
        log.info("Order {} placed successfully.",
                savedOrder.getOrderNumber());
        eventPublisher.publishOrderPlaced(savedOrder);

        return savedOrder.toOrderResponse();
    }
}
