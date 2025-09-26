package br.com.youready.article.d_2025_01_27.image4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class GildedRose {
    Item[] items;
    private final Map<String, Consumer<Item>> rules = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        rules.put("Aged Brie", this::updateAgedBrie);
        rules.put("Backstage passes to a TAFKAL80ETC concert", this::updateBackstagePass);
        rules.put("Sulfuras, Hand of Ragnaros", item -> {});
        rules.put("default", this::updateDefaultItem);
    }

    public void updateQuality() {
        for (Item item : items) {
            Consumer<Item> rule = rules.getOrDefault(item.name, rules.get("default"));
            rule.accept(item);
        }
    }

    // Regras como métodos separados
    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) increaseQuality(item);
    }

    private void updateBackstagePass(Item item) {
        /* Similar à versão 1 */
    }

    private void updateDefaultItem(Item item) {
        /* Similar à versão 1 */
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
