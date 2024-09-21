package com.engineeringwithsandeep.learning.patterns.observer;

public class Demo implements Observer<Person>{
    public static void main(String[] args) {
        new Demo();
    }

    public Demo() {
        Person person = new Person();
        person.subscribe(this);
        for (int i = 20; i < 25; ++i) {
            person.setAge(i);
        }
    }

    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        System.out.println("Person's " + args.propertyName + " has been changed to " + args.newValue);
    }
}
