package com.engineeringwithsandeep.learning.youtube.collections;

import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {

        String singleCartItem = "macbook";

        List<String> cartItem = Collections.singletonList(singleCartItem);

        applyDiscount(cartItem);

        System.out.println("Item in cart:  " + cartItem);
    }

    private static void applyDiscount(List<String> cartItem) {
        if(cartItem.size() == 1) {
            System.out.println("Discount applied: " + cartItem.get(0));
        }
    }
}