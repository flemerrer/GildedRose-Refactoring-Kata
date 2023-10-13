package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

/*
    GildedRoseLegacy app = new GildedRoseLegacy(items);

    int days = 2;
        if (args.length > 0) {
        days = Integer.parseInt(args[0]) + 1;
    }

        for (int i = 0; i < days; i++) {
        System.out.println("-------- day " + i + " --------");
        System.out.println("name, sellIn, quality");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
        app.updateQuality();
    }*/

    @Test
    void assertRefactoredVersionReturnsSameResultAsLegacyVersion() {

        Item[] legacyItems = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)
        };

        List<Item> itemList = new ArrayList<>();

        for (Item legacyItem : legacyItems) {

            try {
                Item newItem = (Item) legacyItem.clone();
                itemList.add(newItem);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        Item[] items = new Item[itemList.size()];
        itemList.toArray(items);

//        legacyItems[0].quality++ ;

        GildedRoseLegacy legacyApp = new GildedRoseLegacy(legacyItems);
        GildedRose app = new GildedRose(items);

        for (int i = 0 ; i <= 1000 ; i++) {
            legacyApp.updateQuality();
            app.updateQuality();
            for (int j = 0; j < legacyItems.length; j++) {
                assertEquals(legacyItems[j], items[j]);
            }
        }
    }

}
