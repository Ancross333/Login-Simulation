package com.example.loginsimulation;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){

        //Instantiate UserInfo object

        UserInfo userInfo = new UserInfo();

        //Create Group Nodes and Scenes

        Group homeRoot = new Group();
        Scene homeScene = new Scene(homeRoot, 600, 900, Color.LIGHTCYAN);

        Group registerRoot = new Group();
        Scene registerScene = new Scene(registerRoot, 600, 900, Color.LIGHTCYAN);

        Group loginSuccessRoot = new Group();
        Scene loginSuccessScene = new Scene(loginSuccessRoot, 600, 900, Color.LIGHTCYAN);





        //Create TextField Objects

        //Username input

        TextField usernameInput = new TextField();


        //Password input

        TextField passwordInput = new TextField();




        //Create Text Objects

        //Header for the home screen

        Text homeHeader = new Text("Log in or Sign up");
        homeHeader.setFont(Font.font("Arial", 50));


        //Prompt to enter username

        Text usernamePrompt = new Text("Username:");
        usernamePrompt.setFont(Font.font("Arial", 24));


        //Prompt to enter password

        Text passwordPrompt = new Text("Password:");
        passwordPrompt.setFont(Font.font("Arial", 24));

        //Bad Login Attempt

        Text badLogin = new Text("The entered credentials don't belong to an account");
        badLogin.setFont(Font.font("Arial", 24));
        badLogin.setFill(Color.RED);





        //Create Button Objects


        //Register Button

        Button registerButton = new Button("Sign up");


        //Log in Button

        Button logInButton = new Button("Log in");



        //Move Text Objects

        //Header on the home screen

        homeHeader.setX(105);
        homeHeader.setY(60);

        //Username prompt

        usernamePrompt.setX(50);
        usernamePrompt.setY(400);


        //Password prompt

        passwordPrompt.setX(50);
        passwordPrompt.setY(550);

        //Bad Login

        badLogin.setX(30);
        badLogin.setY(600);



        //Move TextField objects


        //Username input

        usernameInput.setLayoutX(250);
        usernameInput.setLayoutY(380);


        //Password input

        passwordInput.setLayoutX(250);
        passwordInput.setLayoutY(530);




        //Move Button objects


        //Register button

        registerButton.setLayoutX(400);
        registerButton.setLayoutY(750);


        //Log in button

        logInButton.setLayoutX(150);
        logInButton.setLayoutY(750);


        //Add Children to Root Node

        homeRoot.getChildren().add(homeHeader);
        homeRoot.getChildren().add(usernamePrompt);
        homeRoot.getChildren().add(passwordPrompt);
        homeRoot.getChildren().add(usernameInput);
        homeRoot.getChildren().add(passwordInput);
        homeRoot.getChildren().add(registerButton);
        homeRoot.getChildren().add(logInButton);





        //Nodes for Register Screen

        //Create Text Objects


        //Header for the Register Screen

        Text registerHeader = new Text("Register for an Account");
        registerHeader.setFont(Font.font("Arial", 50));


        //Username and Password Prompts

        Text newUsernamePrompt = new Text("Create a Username");
        newUsernamePrompt.setFont(Font.font("Arial", 24));

        Text newPasswordPrompt = new Text("Create a Password");
        newPasswordPrompt.setFont(Font.font("Arial", 24));


        //Bad Password Error

        Text badPassword = new Text("Make sure your password is at least 8 characters");
        badPassword.setFont(Font.font("Arial", 24));
        badPassword.setFill(Color.RED);


        //Bad Username Error

        Text badUsername = new Text("Username unavailable");
        badUsername.setFont(Font.font("Arial", 24));
        badUsername.setFill(Color.RED);


        //Create Button Objects


        //Register Button

        Button continueButton = new Button("Continue");


        //Back Button

        Button registerBackButton = new Button("Back");




        //Create TextField Objects

        //Username and Password

        TextField newUsername = new TextField();
        TextField newPassword = new TextField();




        //Move Text Objects


        //Header for register screen

        registerHeader.setX(30);
        registerHeader.setY(65);


        //New Username Prompt

        newUsernamePrompt.setX(25);
        newUsernamePrompt.setY(400);


        //New Password Prompt

        newPasswordPrompt.setX(25);
        newPasswordPrompt.setY(550);


        //Bad Password Prompt

        badPassword.setX(35);
        badPassword.setY(600);


        //Bad Username Prompt

        badUsername.setX(175);
        badUsername.setY(600);


        //Move TextField Objects

        //New Username
        
        newUsername.setLayoutX(250);
        newUsername.setLayoutY(380);

        //New Password

        newPassword.setLayoutX(250);
        newPassword.setLayoutY(530);




        //Move Button Objects


        continueButton.setLayoutX(400);
        continueButton.setLayoutY(750);


        registerBackButton.setLayoutX(150);
        registerBackButton.setLayoutY(750);






        //Add Children to Register Screen Root Node

        registerRoot.getChildren().add(registerHeader);
        registerRoot.getChildren().add(newUsername);
        registerRoot.getChildren().add(newPassword);
        registerRoot.getChildren().add(continueButton);
        registerRoot.getChildren().add(newUsernamePrompt);
        registerRoot.getChildren().add(newPasswordPrompt);
        registerRoot.getChildren().add(registerBackButton);





        //Nodes for Successful Login Screen

        //Create Text Objects

        Text helloPrompt = new Text();
        helloPrompt.setFont(Font.font("Arial", 40));

        Text timesLoggedInPrompt = new Text();
        timesLoggedInPrompt.setFont(Font.font("Arial", 24));



        //Create Button Objects

        Button logOutButton = new Button("Log out");



        //Move Texts Objects

        helloPrompt.setX(50);
        helloPrompt.setY(50);

        timesLoggedInPrompt.setX(100);
        timesLoggedInPrompt.setY(200);

        //Move Button Objects

        logOutButton.setLayoutX(200);
        logOutButton.setLayoutY(750);


        //Add Nodes to the Successful Login Root Node

        loginSuccessRoot.getChildren().add(helloPrompt);
        loginSuccessRoot.getChildren().add(logOutButton);
        loginSuccessRoot.getChildren().add(timesLoggedInPrompt);

        //Initialize the Stage

        stage.setScene(homeScene);
        stage.setResizable(false);
        stage.show();









        //Event Handlers for Buttons

        //Register Button

        registerButton.setOnAction(e -> {

            //Change Scenes

            stage.setScene(registerScene);

            //Reset Home Scene

            homeRoot.getChildren().remove(badLogin);
            usernameInput.setText("");
            passwordInput.setText("");

        });


        //Continue Button on Register Screen

        continueButton.setOnAction(e -> {

            if(userInfo.isAvailable(newUsername.getText()) && !newUsername.getText().equals("")){

               if(newPassword.getText().length() >= 8){
                   userInfo.addUser(new User(newUsername.getText(), newPassword.getText()));
                   stage.setScene(homeScene);
                   registerRoot.getChildren().remove(badPassword);
                   registerRoot.getChildren().remove(badUsername);

                   //Reset Screen

                   newUsername.setText("");
                   newPassword.setText("");

               }
               else{
                   //Try - Catch to prevent a duplication error if repeated bad passwords are entered.
                   try{
                       registerRoot.getChildren().add(badPassword);
                       registerRoot.getChildren().remove(badUsername);
                   }
                   catch (Exception j){
                       //Empty to prevent duplicate error
                   }
               }
            }
            else{
                //Try - Catch to prevent a duplication error if repeated bad passwords are entered.
                try{
                    registerRoot.getChildren().add(badUsername);
                    registerRoot.getChildren().remove(badPassword);
                }
                catch (Exception j){
                    //Empty to prevent duplicate error
                }
            }

        });

        //Login Button

        logInButton.setOnAction(e ->{
            if(userInfo.loginAttempt(usernameInput.getText(), passwordInput.getText())){
                stage.setScene(loginSuccessScene);
                homeRoot.getChildren().remove(badLogin);

                //Assign the hello prompt based on the user values

                helloPrompt.setText("Hello " + userInfo.getCurrentUsername() + ",");

                //Condition to see if 'times' should be plural

                if(userInfo.getLoginTimes() > 1)
                    timesLoggedInPrompt.setText("You have logged in " + userInfo.getLoginTimes() + " times.");
                else{
                    timesLoggedInPrompt.setText("This is your first time logging in");
                }
            }
            else{
                //Try - Catch to prevent duplication error

                try{
                    homeRoot.getChildren().add(badLogin);

                }
                catch (Exception j){
                    //Empty catch field to prevent duplication error
                }
            }
        });

        //Back Button (On Register Screen)

        registerBackButton.setOnAction(e ->{
            stage.setScene(homeScene);
            registerRoot.getChildren().remove(badPassword);
            registerRoot.getChildren().remove(badUsername);
        });

        //Log Out Button

        logOutButton.setOnAction(e ->{
            stage.setScene(homeScene);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}