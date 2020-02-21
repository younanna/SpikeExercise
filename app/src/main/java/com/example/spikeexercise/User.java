package com.example.spikeexercise;

public class User {

    // fields
    private String userID;
    private String userPw;

    // constructors
    public User(){}
    public User(String id, String pw) {
        this.userID = id;
        this.userPw = pw;
    }

    // properties
    public void setID (String id) {
        this.userID = id;
    }

    public void setPw (String pw) {
        this.userPw = pw;
    }

    public String getID () {
        return this.userID;
    }


}
