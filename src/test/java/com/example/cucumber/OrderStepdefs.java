package com.example.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class contains step definitions that "read" from an object containing shared state.
 * The object would have been prepared by the other step definitions file (<code>ItemStepdefs</code>).   
 *
 */
public class OrderStepdefs {

    @Autowired
    ItemOrderInfo itemInfo;

    @When("I select a/an {string}")
    public void i_select_item(String itemName) {
        itemInfo.foodOrderService.addItem(new Item(itemName, itemInfo.category));
    }

    @Then("I have a new order")
    public void i_have_new_order() {
        assertTrue("Order was null", itemInfo.foodOrderService.getOrder().isPresent());
    }

    @Then("the order has {int} item(s) in it")
    public void order_has_n_item_in_it(int itemCount) {
        assertEquals("Wrong number of items in order",
                itemCount, itemInfo.foodOrderService.getOrder().get().getItems().size());
    }

    @Then("my current order total is \\$([\\d\\.]+)")
    public void current_order_total_is(String price) {
        assertEquals("Wrong order price",
                new BigDecimal(price), itemInfo.foodOrderService.getOrder().get().getPrice());
    }

}