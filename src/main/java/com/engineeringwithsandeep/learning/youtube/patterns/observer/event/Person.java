package com.engineeringwithsandeep.learning.youtube.patterns.observer.event;

import lombok.Getter;

@Getter
public class Person {
    public Event<PropertyChangedEventArgs> propertyChangedEvent = new Event<>();

    private int age;

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChangedEvent.fire(new PropertyChangedEventArgs(
                this, "age", age
        ));
    }
}
