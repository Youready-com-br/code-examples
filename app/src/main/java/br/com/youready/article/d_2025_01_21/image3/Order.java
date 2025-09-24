package br.com.youready.article.d_2025_01_21.image3;

import java.util.List;

record Order(Long id, List<Item> items) {
    public double getTotal() {
        double totalOrder = 0;
        for (Item item : this.items()) {
            totalOrder += item.price() * item.quantity();
        }
        return totalOrder;
    }
}
