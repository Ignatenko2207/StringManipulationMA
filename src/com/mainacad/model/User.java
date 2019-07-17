package com.mainacad.model;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String login;
    private String password;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Integer id, String login, String password, Gender gender) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.gender = gender;
    }
}
