package com.engineeringwithsandeep.learning.youtube.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class ListToHashMapExample {

    public static void main(String[] args) {
        var students = List.of(
                new Student("1", "Alice", "Alice@gmail.com"),
                new Student("2", "Sandeep", "Sandeep@here.com"),
                new Student("3", "Dhairya", "Dhairya@here.com")
        );

        var studentMap = students.stream().collect(Collectors.toMap(Student::getId, student -> student));

        studentMap.forEach((id, student) -> System.out.println("ID: " + id + ", Name: " + student.getName()));
    }
}

@Data
@AllArgsConstructor
class Student {
    String id;
    String name;
    String email;
}

