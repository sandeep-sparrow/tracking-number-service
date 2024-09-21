package com.engineeringwithsandeep.learning.functional;

public class EmailSender implements Runnable {

    private User user;
    private String subject;

    public EmailSender(User user, String subject) {
        this.user = user;
        this.subject = subject;
    }

    @Override
    public void run() {
        // add our task or process, that we want to run on another thread
        System.out.println("Sending email to " + user.getEmail() + " with subject " + subject);
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000); // simulating time taken to send an email
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Email send to " + user.getEmail());
    }
}
