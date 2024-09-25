package com.engineeringwithsandeep.learning.youtube.patterns.observer.event;

public class PropertyChangedEventArgs {
    public Object source;

    public String propertyName;

    public Object newValue;

    public PropertyChangedEventArgs(Object source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}

