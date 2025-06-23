package org.ashara.chennai.transport.tripsheet.beans;

import org.springframework.stereotype.Component;

@Component
public class LoginCredentials {
    private String itsNumber;
    private String password;

    public String getItsNumber() {
        return itsNumber;
    }

    public void setItsNumber(String itsNumber) {
        this.itsNumber = itsNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
