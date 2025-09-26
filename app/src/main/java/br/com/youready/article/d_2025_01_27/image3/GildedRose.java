package br.com.youready.article.d_2025_01_27.image3;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private final Map<String, UpdateStrategy> strategies = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        strategies.put("Aged Brie", new AgedBrieStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
        strategies.put("default", new DefaultStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdateStrategy strategy = strategies.getOrDefault(item.name, strategies.get("default"));
            strategy.update(item);
        }
    }
}
