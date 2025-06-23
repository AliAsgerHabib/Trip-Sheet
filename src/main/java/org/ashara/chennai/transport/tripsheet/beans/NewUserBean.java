package org.ashara.chennai.transport.tripsheet.beans;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class NewUserBean {

    private String itsNumber;

    private String firstName;

    private String lastName;

    private String password;

    private String department;

    public String getItsNumber() {
        return itsNumber;
    }

    public void setItsNumber(String itsNumber) {
        this.itsNumber = itsNumber;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
