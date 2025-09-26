package br.com.youready.article.d_2025_01_27.image2;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = ItemUpdaterFactory.getUpdaterForItem(item);
            updater.update(item);
        }
    }

    public static class Item {
        public String name;
        public int sellIn;
        public int quality;
    }

    public interface ItemUpdater {
        void update(Item item);
    }

    static class AgedBrieUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality < 50) {
                item.quality++;
            }
            item.sellIn--;
            if (item.sellIn < 0 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    static class BackstagePassUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality < 50) {
                item.quality++;
                incrementQualityForCloseDate(item);
            }
            item.sellIn--;
            if (item.sellIn < 0) {
                item.quality = 0;
            }
        }

        private void incrementQualityForCloseDate(Item item) {
            if (item.sellIn < 10 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 5 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    static class ItemUpdaterFactory {
        public static ItemUpdater getUpdaterForItem(Item item) {
            switch (item.name) {
                case "Aged Brie":
                    return new AgedBrieUpdater();
                case "Backstage passes to a TAFKAL80ETC concert":
                    return new BackstagePassUpdater();
                case "Sulfuras, Hand of Ragnaros":
                    return new SulfurasUpdater();
                default:
                    return new NormalItemUpdater();
            }
        }
    }

    static class NormalItemUpdater implements ItemUpdater {
        public void update(Item item) {
            if (item.quality > 0) {
                item.quality--;
            }
            item.sellIn--;
            if (item.sellIn < 0 && item.quality > 0) {
                item.quality--;
            }
        }
    }

    static class SulfurasUpdater implements ItemUpdater {
        public void update(Item item) {
            // Não altera qualidade nem sellIn
        }
    }
}
