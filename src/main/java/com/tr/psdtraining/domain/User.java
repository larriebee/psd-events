package com.tr.psdtraining.domain;

/**
 * Made by kris n davey lol, on 21/06/2016.
 */
public class User {

    private String name;

    private String emailAddress;

    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }
}
