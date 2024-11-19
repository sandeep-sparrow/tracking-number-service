package com.engineeringwithsandeep.learning.youtube.patterns.factory.abs;

import java.util.ArrayList;
import java.util.List;
import org.reflections.Reflections;

import javafx.util.Pair;

public class AbstractFactory {
    public static void main(String[] args) {

    }
}


interface HotDrink {
    void consume();
}

class Tea implements HotDrink {

    @Override
    public void consume() {
        System.out.println("This Tea is delicious");
    }
}

class Coffee implements HotDrink {

    @Override
    public void consume() {
        System.out.println("This Coffee is delicious");
    }
}

interface HotDrinkFactory {
    HotDrink createHotDrink(int amount);
}

class TeaFactory implements HotDrinkFactory {

    @Override
    public HotDrink createHotDrink(int amount) {
        System.out.println("Put in the tea bag, boil water, pour " + amount + "ml, add lemon, enjoy!" );
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {

    @Override
    public HotDrink createHotDrink(int amount) {
        System.out.println("Grind some beans, boil water, pour " + amount + "ml, add cream and sugar, enjoy!" );
        return new Coffee();
    }
}

class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() {

    }
}