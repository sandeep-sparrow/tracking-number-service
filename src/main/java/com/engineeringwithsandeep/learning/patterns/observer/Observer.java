package com.engineeringwithsandeep.learning.patterns.observer;

public interface Observer<T> {

    void handle(PropertyChangedEventArgs<T> args);
}
