package com.engineeringwithsandeep.learning.youtube.patterns.observer.exercise;

import com.engineeringwithsandeep.learning.youtube.functional.User;

import java.util.List;

public class StreamExample {

    public static void main(String[] args) {
        // Define Input Data
        List<User> users = List.of(
                new User("1", "sandeep", 31, "sandeep.p@gmail.com", 1000.00),
                new User("2", "raj", 35, "exmaple.sample@gmail.com", 2000.00),
                new User("3", "priya", 21, "priya.sample@gmail.com", 3000.00),
                new User("4", "meghana",  31, "meghana.exmaple@gmail.com", 4000.00),
                new User("5", "dhairya", 2, "exmaple.dhairya@gmail.com", 5000.00));

        List<String> modifiedUsers  = users
            .stream() // Splitting phase
            .filter((s) -> s.getAge() > 30) // Apply Phase - agg operations - intermediate - stateless
            .map(User::getName) //  Apply Phase - agg operations - intermediate - stateless
            .sorted() // Apply Phase - agg operations - intermediate - stateful
            .toList(); // Combine phase - agg operations - terminal operation

        modifiedUsers.forEach(System.out::println);

    }

}
