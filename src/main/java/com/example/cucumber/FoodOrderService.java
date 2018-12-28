package com.example.cucumber;

import java.math.BigDecimal;
import java.util.Optional;

public class FoodOrderService {

    private final ItemRepository itemRepository;
    private Order order;

    public FoodOrderService() {
        itemRepository = new BasicItemRepository();
    }

    public Optional<Order> getOrder() {
        return Optional.ofNullable(order);
    }

    public void addItem(Item item) {
        if(order == null) {
            order = new Order();
        }
        order.items.add(item);

        BigDecimal itemPrice = itemRepository.getItemPrice(item);
        order.price = order.price.add(itemPrice);
    }

    public void removeItem(Item item) {
        getOrder().ifPresent(order -> {
            order.items.remove(item);
            order.price = order.price.subtract(itemRepository.getItemPrice(item));
        });
    }

}
