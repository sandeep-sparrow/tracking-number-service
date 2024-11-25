package com.engineeringwithsandeep.learning.youtube.reactive.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderProcessingSystem {

    public static void main(String[] args) {
        Mono<String> orderIdMono = Mono.just("order123");

        // Using flatMap
        orderIdMono
                .flatMap(orderId -> fetchOrderById(orderId)) // Mono<Order>
                .flatMapMany(order -> fetchItemsByOrder(order)) // Flux<Item>
                .subscribe(item -> System.out.println("Item: " + item.itemName));
    }

    static class Order {
        String orderId;
        String customerName;

        // Constructor, getters, setters
        Order(String orderId, String customerName) {
            this.orderId = orderId;
            this.customerName = customerName;
        }
    }

    static class Item {
        String itemId;
        String itemName;

        // Constructor, getters, setters
        Item(String itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }
    }

    public static Mono<Order> fetchOrderById(String orderId) {
        return Mono.just(new Order(orderId, "John Doe"));
    }

    public static Flux<Item> fetchItemsByOrder(Order order) {
        return Flux.just(
                new Item("item1", "Laptop"),
                new Item("item2", "Mouse"),
                new Item("item3", "Keyboard")
        );
    }
}
