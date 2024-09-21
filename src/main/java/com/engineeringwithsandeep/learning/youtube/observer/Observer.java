package com.engineeringwithsandeep.learning.youtube.observer;

public interface Observer<T> {

    void onHandle(PropertyChangedEventArgs<T> args);
}