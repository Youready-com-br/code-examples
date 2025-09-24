package br.com.youready.article.d_2025_01_21.image2;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {

    public void processOrders(List<Order> orders) {
        double totalRevenue = 0;
        List<Order> failedOrders = new ArrayList<>();

        System.out.println("Validating orders...");
        for (Order order : orders) {
            if (order == null || order.items() == null || order.items().isEmpty()) {
                assert order != null;
                System.out.println("Invalid order: " + order.id());
                failedOrders.add(order);
            }
        }

        System.out.println("Processing valid orders...");
        for (Order order : orders) {
            if (failedOrders.contains(order)) {
                continue;
            }

            try {
                double totalOrder = getTotalOrder(order);
                totalRevenue += totalOrder;
                System.out.println("Processed order: " + order.id() + " with total of " + totalOrder);
            } catch (Exception e) {

                System.err.println("Failed to process order: " + order.id());
                failedOrders.add(order);
            }
        }

        System.out.println("Order processing complete. Total revenue: " + totalRevenue);
    }

    // Código extraído!
    private static double getTotalOrder(Order order) {
        double totalOrder = 0;
        for (Item item : order.items()) {
            totalOrder += item.price() * item.quantity();
        }
        return totalOrder;
    }
}
