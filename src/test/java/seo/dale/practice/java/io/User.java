package seo.dale.practice.java.io;

import java.io.Serializable;

class User implements Serializable {

    private String username;
    private transient String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}