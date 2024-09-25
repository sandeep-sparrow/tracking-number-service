package com.engineeringwithsandeep.learning.youtube.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer<T> observer) {
        this.observers.remove(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object newValue) {
        for (Observer<T> observer : observers) {
            observer.handle(new PropertyChangedEventArgs<T>(source, propertyName, newValue));
        }
    }
}
