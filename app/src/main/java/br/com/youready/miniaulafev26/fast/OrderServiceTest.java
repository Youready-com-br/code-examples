package br.com.youready.miniaulafev26.fast;

import br.com.youready.miniaulafev26.InventoryEventPublisher;
import br.com.youready.miniaulafev26.OrderRepository;
import br.com.youready.miniaulafev26.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderServiceTest {

    @Test
    void tooExpensiveToWrite() {
        // Criando os mocks...
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        InventoryEventPublisher eventPublisher = Mockito.mock(InventoryEventPublisher.class);

        // ...Configurando os mocks

        OrderServiceFastImpl orderService = new OrderServiceFastImpl(productRepository, orderRepository, eventPublisher);
        OrderRequestFastImpl orderRequest = new OrderRequestFastImpl("teste@gmail.com", null, false);

        // Para finalmente começar a usar o método...
        orderService.placeOrder(orderRequest);
    }
}
