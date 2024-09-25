package com.engineeringwithsandeep.learning.youtube.patterns.observer;

import lombok.Getter;

@Getter
public class Person extends Observable<Person> {
    private int age;

    public Person() {
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChanged(this, "age", age);
    }
}
