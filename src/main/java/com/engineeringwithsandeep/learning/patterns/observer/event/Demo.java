package com.engineeringwithsandeep.learning.patterns.observer.event;

public class Demo {
    public static void main(String[] args) {
        Person person = new Person();

        Subscription<PropertyChangedEventArgs> subscription =
        person.propertyChangedEvent.addHandler(x -> System.out.println("Person's " + x.propertyName + " has been changed"));

        person.setAge(10);
        person.setAge(11);
        subscription.close();
        person.setAge(12);
    }
}
