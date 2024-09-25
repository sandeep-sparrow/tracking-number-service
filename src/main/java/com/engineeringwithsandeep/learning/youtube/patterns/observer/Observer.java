package com.engineeringwithsandeep.learning.youtube.patterns.observer;

public interface Observer<T> {

    void handle(PropertyChangedEventArgs<T> args);
}
