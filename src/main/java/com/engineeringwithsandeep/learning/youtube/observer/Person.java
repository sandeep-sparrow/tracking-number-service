package com.engineeringwithsandeep.learning.youtube.observer;

public class Person extends Observable {

    public String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        if(age == this.age) return;
        this.age = age;
        onPropertyChanged(this, "age", age);
    }

    public int getAge() {
        return age;
    }
}
