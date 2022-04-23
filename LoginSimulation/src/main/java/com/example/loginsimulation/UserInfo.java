package com.example.loginsimulation;

import java.util.ArrayList;
import java.util.HashMap;

public class UserInfo {

    //Instance Variables

    ArrayList<User> users = new ArrayList<>();
    HashMap<String, String> userInfo = new HashMap<>();
    User currentUser;
    //Constructor for UserInfo class

    public UserInfo(){

    }

    //Check Username Availability

    public boolean isAvailable(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    //Add a user to the database

    public void addUser (User u){
        users.add(u);
        userInfo.put(u.getUsername(), u.getPassword());
    }

    public boolean loginAttempt (String u, String p){

        //Check if the username entered exists in database

        if(userInfo.containsKey(u)) {
            if(userInfo.get(u).equals(p)){

                //Checks which user logged in

                for(User user : users){

                    //Recognizes that the user has logged in, incrementing it's times logged in value

                    if(user.getUsername().equals(u)){
                        user.logIn();
                        currentUser = user;
                    }

                }

                return true;
            }
        }
        return false;
    }

    //Method to return the number of times the current user has logged int

    public int getLoginTimes(){
        return currentUser.getTimesLoggedIn();
    }

    //Clear the current user as they log out

    public void logOut(){
        currentUser = null;
    }

    public String getCurrentUsername(){
        return currentUser.getUsername();
    }

}
