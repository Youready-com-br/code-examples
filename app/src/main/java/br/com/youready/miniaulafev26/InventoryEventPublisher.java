package br.com.youready.miniaulafev26;

public interface InventoryEventPublisher {
    void publishOrderPlaced(Order order);

    void publishStockUpdated(StockUpdate update);
}
