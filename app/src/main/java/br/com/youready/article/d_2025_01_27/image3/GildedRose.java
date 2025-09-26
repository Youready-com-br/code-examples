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

    public static class Item {
        public String name;
        public int sellIn;
        public int quality;
    }

    public interface UpdateStrategy {
        void update(Item item);
    }

    static class AgedBrieStrategy implements UpdateStrategy {
        public void update(Item item) {
            if (item.quality < 50) {
                item.quality++;
                item.sellIn--;
                if (item.sellIn < 0 && item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }

    static class BackstagePassStrategy implements UpdateStrategy {
        public void update(Item item) {
            // Similar à versão 1
        }
    }

    static class DefaultStrategy implements UpdateStrategy {
        public void update(Item item) {
            // Similar à versão 1
        }
    }

    static class SulfurasStrategy implements UpdateStrategy {
        public void update(Item item) {
            // Nada acontece
        }
    }
}
