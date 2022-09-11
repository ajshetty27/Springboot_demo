package com.REN.demo_app.data.models;

import javax.persistence.*;
import java.util.Objects;

@Entity

public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;

    public User(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override

    public String toString() {
       return "Employee{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastname='" + lastname + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '}';
    }

}
