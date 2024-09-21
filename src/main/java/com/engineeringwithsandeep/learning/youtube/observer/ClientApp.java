package com.engineeringwithsandeep.learning.youtube.observer;

public class ClientApp implements Observer {
    public static void main(String[] args) {
        new ClientApp();
    }

    public ClientApp() {
        Person person = new Person("max", 15);
        person.subscribe(this);
        person.subscribe(new EmailSendingObserver(person));
        for (int i = 0; i < 10; i++) {
            person.setAge(person.getAge() + 1);
        }
    }

    @Override
    public void onHandle(PropertyChangedEventArgs args) {
        System.out.println("Person " + args.propertyName + " changed to: " + args.newValue);
    }
}

class EmailSendingObserver implements Observer {

    private Person person;

    public EmailSendingObserver(Person person) {
        this.person = person;
    }

    @Override
    public void onHandle(PropertyChangedEventArgs args) {
        System.out.println(person.name.toUpperCase() + " new " + args.propertyName + " is: " + args.newValue + ", Sending Age Changed Email Notification...");
    }
}
