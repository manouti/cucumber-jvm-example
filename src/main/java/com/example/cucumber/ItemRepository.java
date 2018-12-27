package com.example.cucumber;

import java.math.BigDecimal;

interface ItemRepository {

    BigDecimal getItemPrice(Item item);

}
