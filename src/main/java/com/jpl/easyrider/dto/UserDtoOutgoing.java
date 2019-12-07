package com.jpl.easyrider.dto;


import com.jpl.easyrider.domain.DBFile;

public class UserDtoOutgoing {

    private String firstName;
    private String lastName;
    private int weight;
    private String email;
    private String selfDescription;
    private DBFile portrait;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    public DBFile getPortrait() {
        return portrait;
    }

    public void setPortrait(DBFile portrait) {
        this.portrait = portrait;
    }
}
