package com.example.loginsimulation;

public class User {

    private String username;
    private String password;
    private int timesLoggedIn;

    //Constructor for the User Class

    public User(String username, String password){
        this.username = username;
        this.password = password;
        timesLoggedIn = 0;
    }

    //Accessor Method for Username

    public String getUsername(){
        return username;
    }

    //Accessor Method for Password

    public String getPassword(){
        return password;
    }

    public void logIn(){
        timesLoggedIn++;
    }

    public int getTimesLoggedIn(){
        return timesLoggedIn;
    }
}
