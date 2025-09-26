package br.com.youready.article.d_2025_01_27.image3;

class AgedBrieStrategy implements UpdateStrategy {
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
