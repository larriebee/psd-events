package com.tr.psdtraining.domain;

import javax.persistence.*;

/**
 * Made by kris n davey lol, on 21/06/2016.
 */
@Entity
@Table(name = "user")
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id = null;

    @Column
    private String name;

    @Column
    private String emailAddress;

    public User () {

    }

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
