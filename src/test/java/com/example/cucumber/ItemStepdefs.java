package com.example.cucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * This class contains step definitions for some of the steps in the 
 * feature file <code>adding_an_item.feature</code>. Specifically, it contains steps
 * that "write" to an object containing shared state. The object will subsequently be "read"
 * by the other step definitions file (<code>OrderStepdefs</code>).   
 *
 */
@ContextConfiguration(classes = SpringTestConfig.class)
public class ItemStepdefs {

    @Autowired
    ItemOrderInfo itemInfo;

    @Given("I have not yet ordered anything")
    public void no_order_yet() {
        itemInfo.foodOrderService = new FoodOrderService();
    }

    @When("I go to the {string} category")
    public void i_go_to_category(String category) {
        this.itemInfo.category = category;
    }

    @When("I remove the item {string}")
    public void i_remove_item(String itemName) {
        this.itemInfo.foodOrderService.removeItem(new Item(itemName, ""));
    }

    @Given("I have a current order")
    public void i_have_an_order() {
        itemInfo.foodOrderService = new FoodOrderService();
    }

    @Given("it already contains a/an {string}")
    public void order_contains_item(String itemName) {
        itemInfo.foodOrderService.addItem(new Item(itemName, ""));
    }
}