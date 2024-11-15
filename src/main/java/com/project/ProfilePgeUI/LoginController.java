package com.project.ProfilePgeUI;

import java.util.concurrent.ExecutionException;

import com.project.MainApp;
import com.project.OrderPageUI.OrderPageUI;
import com.project.fireConfig.dataService;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginController {
    private MainApp mainApp;
    private dataService DataService;
    public static String key;

    public LoginController(MainApp mainApp) {
        this.mainApp = mainApp;
        DataService = new dataService();
        
    }

    public VBox getLoginPage() {
        Image loginSignupBackgroundImage=new Image("com\\project\\assets\\HeathImages\\loginbackground.jpg",1940,860,false,false);
        ImageView backImageView=new ImageView(loginSignupBackgroundImage);
        Label lb1=new Label("Login");
        lb1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 43));
        lb1.setStyle(" -fx-text-fill: white;");
        lb1.setLayoutX(240);
        lb1.setLayoutY(50);

        Label usrname=new Label("Username");
        usrname.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        usrname.setStyle(" -fx-text-fill: white;");
        usrname.setLayoutX(100);
        usrname.setLayoutY(130);
        TextField username=new TextField();
        username.setPromptText("Enter username"); 
        username.setPrefWidth(400);
        username.setPrefHeight(40);
        username.setLayoutX(100);
        username.setLayoutY(150);
        
        Label pass=new Label("Password");
        pass.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        pass.setStyle(" -fx-text-fill: white;");
        pass.setLayoutX(100);
        pass.setLayoutY(220);
        PasswordField password=new PasswordField();
        password.setPromptText("Enter password"); 
        password.setPrefWidth(400);
        password.setPrefHeight(40);
        password.setLayoutX(100);
        password.setLayoutY(240);

        Button loginButton = new Button("Login as user");
        loginButton.setPrefSize(178, 25);
        loginButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 19));
        loginButton.setStyle(" -fx-background-color: #ef6c00; -fx-text-fill: white;");
        loginButton.setLayoutX(110);
        loginButton.setLayoutY(350);
        loginButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            loginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
        });

        loginButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            loginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        });
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleUserLogin(username.getText(), password.getText());
                username.clear();
                password.clear();
            }
        });


        Button adminloginButton = new Button("Login as admin");
        adminloginButton.setPrefSize(178, 25);
        adminloginButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 19));
        adminloginButton.setStyle(" -fx-background-color: #ef6c00; -fx-text-fill: white;");
        adminloginButton.setLayoutX(290);
        adminloginButton.setLayoutY(350);
        adminloginButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            adminloginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
        });

        adminloginButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            adminloginButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        });
        adminloginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleAdminLogin(username.getText(), password.getText());
                username.clear();
                password.clear();
            }
        });


        Label ac=new Label("Don't have account yet? ");
        ac.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        ac.setStyle(" -fx-text-fill: white;");
        Button login=new Button("Create Account");
        login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainApp.showLoginPage();
                
            }
        });
        login.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 17));
        login.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 17));
        login.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-border-color: transparent;");
        login.setMaxSize(200, 50);
        HBox hb=new HBox(ac,login);
        hb.setLayoutX(150);
        hb.setLayoutY(390);
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainApp.showCreateAccountPage();
                //showSignupScene();
                // username.clear();
                // password.clear();
            }
        });

        

        
        // Label ac = new Label("Don't have account yet? ");
        // ac.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 15));
        // ac.setStyle(" -fx-text-fill: white;");
        
        // Button makeAccountButton = new Button("Create Account");
        // makeAccountButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 17));
        // makeAccountButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent; -fx-border-color: transparent;");
        // makeAccountButton.setMaxSize(200, 50);
        // HBox hb = new HBox(ac, makeAccountButton);
        // hb.setLayoutX(150);
        // hb.setLayoutY(390);
        // makeAccountButton.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent event) {
        //         mainApp.showCreateAccountPage();
        //         //showSignupScene();
        //         // username.clear();
        //         // password.clear();
        //     }
        // });


        Pane vpane=new Pane(lb1,usrname,username,pass,password,loginButton,adminloginButton,hb);


        
        Pane pane=new Pane(backImageView,vpane);
        VBox vBox=new VBox(pane);
        ScrollPane scrollPane=new ScrollPane(vBox);
        scrollPane.setPrefSize(1950, 980);

        VBox vb=new VBox(scrollPane);
        return vb;

    }

    // private void handleLogin(String username, String password) {
    //     try {
    //         if (DataService.authenticateUser(username, password)) {
    //             key = username;
    //             mainApp.showHomePage();
    //         } else {
    //             Alert alert = new Alert(AlertType.ERROR);
    //             alert.setTitle("Error Dialog");
    //             alert.setHeaderText(null);
    //             alert.setContentText("Invalid Credentials");

    //             // Show the alert
    //             alert.showAndWait();
    //             System.out.println("Invalid credentials");
    //             key = null;
    //         }
    //     } catch (ExecutionException | InterruptedException ex) {
    //         ex.printStackTrace();
    //     }

    // }

    private void handleUserLogin(String username, String password) {
        try {
            if (DataService.authenticateUser(username, password) && !DataService.isAdmin(username)) {
                key = username;
               // mainApp.showHomePage();
               OrderPageUI.showOrderDetails();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Credentials");

                // Show the alert
                alert.showAndWait();
                System.out.println("Invalid client credentials");
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    private void handleAdminLogin(String username, String password) {
        try {
            if (DataService.authenticateUser(username, password) && DataService.isAdmin(username)) {
                mainApp.showHomePage();
            } else {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Admin Credentials");

                // Show the alert
                alert.showAndWait();
                System.out.println("Invalid admin credentials");
            }
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
