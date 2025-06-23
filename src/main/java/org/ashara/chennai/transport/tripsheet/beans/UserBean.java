package org.ashara.chennai.transport.tripsheet.beans;


import java.time.LocalDateTime;

public class UserBean {

    private Integer id;

    private String itsNumber;

    private String name;

    private String loginStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItsNumber() {
        return itsNumber;
    }

    public void setItsNumber(String itsNumber) {
        this.itsNumber = itsNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
