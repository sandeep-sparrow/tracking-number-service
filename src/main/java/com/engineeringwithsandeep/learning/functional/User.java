package com.engineeringwithsandeep.learning.functional;


public class User {

    private String id;
    private String name;
    private int age;
    private String email;
    private double balance;
    private UserLoyaltyProgram userLoyaltyProgram;

    public User(String id, String name, int age, String email, double balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.balance = balance;
    }

    public UserLoyaltyProgram getUserLoyaltyProgram() {
        return userLoyaltyProgram;
    }

    public void setUserLoyaltyProgram(UserLoyaltyProgram userLoyaltyProgram) {
        this.userLoyaltyProgram = userLoyaltyProgram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addAmount(double amount) {
        System.out.println("Adding amount: " + amount);
        this.balance = this.balance + amount;
    }
}
