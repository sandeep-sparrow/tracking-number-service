package com.engineeringwithsandeep.learning.youtube.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    List<Observer<T>> observers = new ArrayList<>();

    void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    void unsubscribe(Observer<T> observer) {
        observers.remove(observer);
    }

    void onPropertyChanged(T source, String propertyName, Object newValue) {
        for(Observer<T> observer : observers) {
            observer.onHandle(new PropertyChangedEventArgs<>(source, propertyName, newValue));
        }
    }
}
