package br.com.youready.article.d_2025_01_21.image5;

import java.util.List;

record Order(Long id, List<Item> items) {
    public double getTotal(List<String> discountItens) {
        double totalOrder = 0;
        double discount;
        for (Item item : this.items()) {
            if (discountItens.contains(item.name())) {
                discount = 0.75;
            } else {
                discount = 1;
            }
            totalOrder += item.price() * item.quantity() * discount;
        }
        return totalOrder;
    }
}
