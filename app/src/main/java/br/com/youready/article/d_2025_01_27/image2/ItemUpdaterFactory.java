package br.com.youready.article.d_2025_01_27.image2;

class ItemUpdaterFactory {
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
