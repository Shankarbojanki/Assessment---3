package com.shankarBojanki.ApiEntity;

import javax.persistence.Entity;
import java.util.Date;


public class Employees {


    private Long id;

    private String first_name;

    private String last_name;

    private String email;

    private String gender;

    private Date joined_on;

    private int salery;

    private String role;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoined_on() {
        return joined_on;
    }

    public void setJoined_on(Date joined_on) {
        this.joined_on = joined_on;
    }

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        this.salery = salery;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
