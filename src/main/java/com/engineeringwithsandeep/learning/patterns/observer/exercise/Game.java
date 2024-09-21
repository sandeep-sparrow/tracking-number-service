package com.engineeringwithsandeep.learning.patterns.observer.exercise;

public class Game {

    public Event<Void> ratEnters = new Event<>();

    public Event<Void> ratDies = new Event<>();

    public Event<Rat> notifyRat = new Event<Rat>();
}
