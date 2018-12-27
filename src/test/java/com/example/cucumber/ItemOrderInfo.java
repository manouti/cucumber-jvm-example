package com.example.cucumber;

import org.springframework.stereotype.Component;

/**
 * This is just a wrapper around the stuff we need to pass between <code>ItemStepdefs</code>
 * and <code>OrderStepdefs</code>, using dependency injection. 
 *
 */
@Component
public class ItemOrderInfo {

    String category;
    FoodOrderService foodOrderService;

}
