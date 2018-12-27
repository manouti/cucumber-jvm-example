package com.example.cucumber;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Order {

    List<Item> items = new ArrayList<>();
    BigDecimal price = BigDecimal.ZERO;

}
