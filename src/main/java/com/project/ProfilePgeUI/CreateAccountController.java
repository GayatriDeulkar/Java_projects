package com.project.ProfilePgeUI;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import com.project.MainApp;
import com.project.fireConfig.dataService;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CreateAccountController {
    private MainApp mainApp;

    public CreateAccountController(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public VBox getCreateAccountPage() {
        
        Image loginSignupBackgroundImage=new Image("com\\project\\assets\\HeathImages\\loginbackground.jpg",1940,860,false,false);
        ImageView backImageView=new ImageView(loginSignupBackgroundImage);


        // Label lb1=new Label("Login");
        // lb1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 43));
        // lb1.setStyle(" -fx-text-fill: white;");
        // lb1.setLayoutX(240);
        // lb1.setLayoutY(50);

        // Label usrname=new Label("Username");
        // usrname.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        // usrname.setStyle(" -fx-text-fill: white;");
        // usrname.setLayoutX(100);
        // usrname.setLayoutY(130);
        // TextField username=new TextField();
        // username.setPromptText("Enter username"); 
        // username.setPrefWidth(400);
        // username.setPrefHeight(40);
        // username.setLayoutX(100);
        // username.setLayoutY(150);
        
        // Label pass=new Label("Password");
        // pass.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        // pass.setStyle(" -fx-text-fill: white;");
        // pass.setLayoutX(100);
        // pass.setLayoutY(220);
        // PasswordField password=new PasswordField();
        // password.setPromptText("Enter password"); 
        // password.setPrefWidth(400);
        // password.setPrefHeight(40);
        // password.setLayoutX(100);
        // password.setLayoutY(240);

        // Button loginButton = new Button("Login");
        // loginButton.setPrefSize(150, 25);
        // loginButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 19));
        // loginButton.setStyle(" -fx-background-color: #ef6c00; -fx-text-fill: white;");
        // loginButton.setLayoutX(220);
        // loginButton.setLayoutY(350);
        // loginButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
        //     loginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
        // });

        // loginButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
        //     loginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        // });

        
        
        // Label ac=new Label("Don't have account yet? ");
        // ac.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        // ac.setStyle(" -fx-text-fill: white;");
        // Label makeac=new Label("Create Account");
        // makeac.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 17));
        // makeac.setStyle(" -fx-text-fill: white;");
        // HBox hb=new HBox(ac,makeac);
        // hb.setLayoutX(150);
        // hb.setLayoutY(390);




        // Pane vpane=new Pane(lb1,usrname,username,pass,password,loginButton,hb);


        
        // Pane pane=new Pane(backImageView,vpane);
        Label lb1=new Label("Create Account");
        lb1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 43));
        lb1.setStyle(" -fx-text-fill: white;");
        lb1.setLayoutX(120);
        lb1.setLayoutY(50);

        Label name=new Label("Name");
        name.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        name.setStyle(" -fx-text-fill: white;");
        name.setLayoutX(100);
        name.setLayoutY(130);
        TextField uname=new TextField();
        uname.setPromptText("Enter your full name"); 
        uname.setPrefWidth(400);
        uname.setPrefHeight(30);
        uname.setLayoutX(100);
        uname.setLayoutY(150);
        
        Label email=new Label("Email");
        email.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        email.setStyle(" -fx-text-fill: white;");
        email.setLayoutX(100);
        email.setLayoutY(200);
        TextField emailField=new TextField();
        emailField.setPromptText("Enter your email"); 
        emailField.setPrefWidth(400);
        emailField.setPrefHeight(30);
        emailField.setLayoutX(100);
        emailField.setLayoutY(220);

        Label usrname=new Label("Username");
        usrname.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        usrname.setStyle(" -fx-text-fill: white;");
        usrname.setLayoutX(100);
        usrname.setLayoutY(270);
        TextField usernameTextField=new TextField();
        usernameTextField.setPromptText("Enter username"); 
        usernameTextField.setPrefWidth(400);
        usernameTextField.setPrefHeight(30);
        usernameTextField.setLayoutX(100);
        usernameTextField.setLayoutY(290);

        Label pass=new Label("Password");
        pass.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        pass.setStyle(" -fx-text-fill: white;");
        pass.setLayoutX(100);
        pass.setLayoutY(330);
        PasswordField passwordField=new PasswordField(); 
        passwordField.setPromptText("Enter password"); 
        passwordField.setPrefWidth(400);
        passwordField.setPrefHeight(30);
        passwordField.setLayoutX(100);
        passwordField.setLayoutY(350);
        
        Label mob=new Label("Mobile No.");
        mob.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        mob.setStyle(" -fx-text-fill: white;");
        mob.setLayoutX(100);
        mob.setLayoutY(400);
        TextField mobField=new TextField();
        mobField.setPromptText("Enter your moblile no."); 
        mobField.setPrefWidth(400);
        mobField.setPrefHeight(30);
        mobField.setLayoutX(100);
        mobField.setLayoutY(420);

        Label info=new Label("Add shipping information");
        info.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 25));
        info.setStyle(" -fx-text-fill: white;");
        info.setLayoutX(100);
        info.setLayoutY(500);

        Label address=new Label("Shipping address");
        address.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        address.setStyle(" -fx-text-fill: white;");
        address.setLayoutX(100);
        address.setLayoutY(550);
        TextField shippaddressField=new TextField();
        shippaddressField.setPromptText("Enter your shipping address"); 
        shippaddressField.setPrefWidth(400);
        shippaddressField.setPrefHeight(30);
        shippaddressField.setLayoutX(100);
        shippaddressField.setLayoutY(580);

        Label pincode=new Label("Pincode");
        pincode.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        pincode.setStyle(" -fx-text-fill: white;");
        pincode.setLayoutX(100);
        pincode.setLayoutY(630);
        TextField pincodeField=new TextField();
        pincodeField.setPromptText("Enter your pincode"); 
        pincodeField.setPrefWidth(400);
        pincodeField.setPrefHeight(30);
        pincodeField.setLayoutX(100);
        pincodeField.setLayoutY(650);

        Button createAccButton = new Button("Create Account");
        createAccButton.setPrefSize(200, 25);
        createAccButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 19));
        createAccButton.setStyle(" -fx-background-color: #ef6c00; -fx-text-fill: white;");
        createAccButton.setLayoutX(190);
        createAccButton.setLayoutY(700);
        createAccButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            createAccButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
        });

        createAccButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            createAccButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        });
        // Set action for the signup button
        createAccButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleSignup(uname.getText(), emailField.getText(),usernameTextField.getText(),passwordField.getText(),mobField.getText(),shippaddressField.getText(),pincodeField.getText()); // Handle signup
            }
        });

        Label ac=new Label("Already have account ? ");
        ac.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        ac.setStyle(" -fx-text-fill: white;");
        Label login=new Label("Login");
        login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainApp.showLoginPage();
                
            }
        });
        login.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 17));
        login.setStyle(" -fx-text-fill: white;");
        HBox hb=new HBox(ac,login);
        hb.setLayoutX(185);
        hb.setLayoutY(740);





        Pane pn=new Pane(backImageView,lb1,name,uname,email,emailField,usrname,usernameTextField,mob,mobField,pass,passwordField,info,address,shippaddressField,pincode,pincodeField,createAccButton,hb);
        VBox vBox=new VBox(pn);
        ScrollPane scrollPane=new ScrollPane(vBox);
        scrollPane.setPrefSize(1950, 980);

        VBox vb=new VBox(scrollPane);
        return vb;
    }

    // Method to handle signup action
    private void handleSignup(String name, String email,String username,String password,String mobileNo,String address,String pincode) {
        dataService DataService;
        // Local instance of DataService
        try {
            DataService = new dataService(); // Initialize DataService instance
            // Create a map to hold user data
            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("email", name);
            data.put("username", username);
            data.put("password", password);
            data.put("mobileNo", mobileNo);
            data.put("address", address);
            data.put("pincode", pincode);
            // Add user data to Firestore
            DataService.addData("users", username, data);
            System.out.println("User registered successfully");

            // Navigate back to the login scene
            mainApp.showLoginPage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}