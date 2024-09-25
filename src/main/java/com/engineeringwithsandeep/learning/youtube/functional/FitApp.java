package com.engineeringwithsandeep.learning.youtube.functional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.*;
import java.util.stream.Collectors;

public class FitApp {
    public static void main(String[] args) {
        // Supply a DB so that we can lazy initialize DB connection whenever required

        System.out.println(Thread.currentThread().getName());
        System.out.println("Main application is running...");

        System.out.println("\nDemo - Supplier Interface");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Supplier<DatabaseConnection> databaseConnectionSupplier = DatabaseConnection::connect; // - Supplier<T>

        // Some complex task like authentication
        System.out.println("Performing some complex tasks like");
        System.out.println("Authentication");
        System.out.println("Connection with Could");
        System.out.println("Getting Db connection configuration");
        System.out.println("Getting Driver details");
        System.out.println("Connecting");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        DatabaseConnection databaseConnection = databaseConnectionSupplier.get();
        databaseConnection.query("select * from USERS");
        System.out.println("loading mock data");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("mock data loaded");
        // mock data received from above DB query
        List<User> users = List.of(
                new User("1", "sandeep", 31, "sandeep.p@gmail.com", 1000.00),
                new User("2", "raj", 35, "exmaple.sample@gmail.com", 2000.00),
                new User("3", "priya", 21, "priya.sample@gmail.com", 3000.00),
                new User("4", "meghana",  31, "meghana.exmaple@gmail.com", 4000.00),
                new User("5", "dhairya", 2, "exmaple.dhairya@gmail.com", 5000.00));

        // We want or our requirement is to map the above data to just get user email
        Function<User, String> userFn = User::getEmail;     // - Function<T, R>

        Predicate<User> userFilter = u -> u.getAge() > 18;  // - Predicate

        System.out.println(userFn);

        // Deferred Exception Handling
        Consumer<User> userConsumerWithException = u -> System.out.println(u.getUserLoyaltyProgram().getPoints());

        // Example of optional
        Consumer<User> userConsumerWithOptional =  u -> {
            Optional<UserLoyaltyProgram> optionalUserLoyaltyProgram = Optional.ofNullable(u.getUserLoyaltyProgram());
            optionalUserLoyaltyProgram.ifPresentOrElse(
                    loyaltyProgram -> System.out.println("Loyalty Points: " + loyaltyProgram.getPoints() + " for user: " + u.getName()),
                    () -> System.out.println("User is not enrolled or eligible for loyalty program")
            );
        };

        /* Stream has 2 phases
         *  split > apply > combine
         *  split > agg operations (intermediate operation) > agg operations (terminal operational)
         */

        System.out.println("\nDemo - Predicate and Function Interface");
        System.out.println("streaming data using predicate and function");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<User> usersAboveAgeOf18  = users
                .stream()            // Stream<User>
                .filter(userFilter)  // Stream<User>
                .collect(Collectors.toList()); // List<String> - Terminal Operation
        System.out.println("streaming data complete");
        System.out.println("\nDemo - Consumer Interface - consuming data");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Consumer<User> printMethod = (user) -> System.out.println(user.getEmail()); // - Consumer<T>
        usersAboveAgeOf18.forEach(printMethod);

        System.out.println("\nDemo - Runnable Interface - running email sending task on background thread");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (User user : usersAboveAgeOf18) {
            new Thread(() -> {
                System.out.println("Sending email to " + user.getEmail() + " with subject " + "welcome to my fitApp");
                // Adding UserLoyalty
                if (user.getAge() > 30){
                    UserLoyaltyProgram userLoyaltyProgram = new UserLoyaltyProgram(10.0);
                    user.setUserLoyaltyProgram(userLoyaltyProgram);
                }
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000); // Simulating time taken to send an email
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Email send to " + user.getEmail() + " complete");
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nDemo - Callable Interface - run task on different threads and expecting result result");
        Callable<Double> fetcher = new WalletService("ABC123");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            Future<Double> future = executorService.submit(fetcher);
            Double balance1 = future.get();
            System.out.println("Balance: " + balance1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        System.out.println("\nDemo - BiConsumer Interface");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map<User, Double> userBalanceUpdates = new HashMap<>();

        User sandeep = new User("1", "sandeep", 31, "sandeep.p@gmail.com", 1000.00);
        User raj = new User("1", "raj", 32, "raj.p@gmail.com", 2000.00);

        userBalanceUpdates.put(sandeep, Double.valueOf(200.00));
        userBalanceUpdates.put(raj, Double.valueOf(300.00));

        BiConsumer<User, Double> updateBalance = User::addAmount;

        userBalanceUpdates.forEach(updateBalance);

        userBalanceUpdates.keySet().forEach((user) -> System.out.println("Updated balance: " + user.getBalance()));

        System.out.println("Main application is still running...");

        System.out.println("\nDemo - Optional container class");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        usersAboveAgeOf18.forEach(userConsumerWithOptional);
    }
}
