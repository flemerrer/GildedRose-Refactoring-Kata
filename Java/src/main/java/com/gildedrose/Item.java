package com.gildedrose;

import java.util.Objects;

public class Item implements Cloneable {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Item(this.name, this.sellIn, this.quality);
    }

    @Override
    public boolean equals(Object object) {
        Item other = (Item) object;
        return Objects.equals(name, other.name) && Objects.equals(sellIn, other.sellIn) && Objects.equals(quality, other.quality);
    }
}
