package com.tr.psdtraining.domain;

import com.tr.psdtraining.domain.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Made by kris n' dave lol, on 21/06/2016.
 */
@Entity
@Table(name = "event")
public class Event {

    private String location;

    private Date time;

    private User owner;

    private String locationDetails;

    public Event() {

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
