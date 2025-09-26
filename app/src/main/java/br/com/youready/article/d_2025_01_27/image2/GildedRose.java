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
}
