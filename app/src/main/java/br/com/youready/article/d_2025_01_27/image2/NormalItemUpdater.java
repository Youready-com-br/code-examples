package br.com.youready.article.d_2025_01_27.image2;

class NormalItemUpdater implements ItemUpdater {
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
