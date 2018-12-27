package com.example.cucumber;

import java.math.BigDecimal;

public class BasicItemRepository implements ItemRepository {

    @Override
    public BigDecimal getItemPrice(Item item) {
        if(item.name.equalsIgnoreCase("Chicken Sandwich")) {
            return new BigDecimal(9);
        } else if(item.name.equalsIgnoreCase("Oreo Cheesecake")) {
            return new BigDecimal(7);
        } else if(item.name.equalsIgnoreCase("Cheeseburger")) {
            return new BigDecimal(9);
        }
        throw new IllegalArgumentException("Unknown item " + item.name);
    }

}
