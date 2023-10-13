package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    void assertClonedItemReturnsItemWithSameProperties() {

        //Setup
        Item item = new Item("Bob cochonou légendaire", 20, 5);

        //Action
        Item clonedItem = null;
        try {
            clonedItem = (Item) item.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        //Assertions
        assertEquals(item, clonedItem);
    }

}
