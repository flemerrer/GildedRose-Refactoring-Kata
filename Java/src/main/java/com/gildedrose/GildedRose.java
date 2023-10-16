package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            Item item = items[i];

            if (isAgedBrie(item)) {
                increaseQuality(item);
            } else if (isBackstagePass(item)) {
                updateBackstagePassQuality(item);
            } else if (isConjuredItem(item)) {
                decreaseQuality(item);
                decreaseQuality(item);
            } else {
                decreaseQuality(item);
            }

            decreaseSellIn(item);

            if (item.sellIn < 0) {
                if (isAgedBrie(item)) {
                    increaseQuality(item);
                } else if (isBackstagePass(item)) {
                    item.quality = 0;
                } else {
                    decreaseQuality(item);
                }
            }
        }

    }

    private static void decreaseSellIn(Item item) {
        if (!isLegendaryItem(item)) {
            item.sellIn -= 1;
        }
    }

    private static void updateBackstagePassQuality(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            if (!isLegendaryItem(item)) {
                item.quality -= 1;
            }
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private static boolean isLegendaryItem(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isConjuredItem(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

    private static boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
