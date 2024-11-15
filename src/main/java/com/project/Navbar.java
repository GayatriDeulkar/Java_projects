package com.project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Navbar {
    private final VBox navbar;
    private final MainApp mainApp;
    private final Button home;
    private final Button food;
    private final Button dog;
    private final Button medicine;
    private final Button fashion;
    private final Button heathcare;
    private final Button grooming;
    private final Button helpingHandButton;
    private final Button profile;

    public Navbar(MainApp app) {
        this.mainApp = app;
        this.navbar = new VBox();
        this.home = new Button("HOME");
        this.food = new Button("FOOD");
        this.dog = new Button("DOGS");
        this.medicine = new Button("MEDICINE");
        this.fashion = new Button("FASHION");
        this.heathcare = new Button("HEALTHCARE");
        this.grooming = new Button("GROOMING");
        this.helpingHandButton = new Button("HELPING HAND");
        this.profile = new Button("PROFILE");
        initialize();
    }

    private void initialize() {
        initializeButton(home, "HOME", e -> mainApp.showHomePage());
        initializeButton(dog, "DOGS", e -> mainApp.showDogsPage());
        initializeButton(food, "FOOD", e -> mainApp.showFoodPage());
        initializeButton(medicine, "MEDICINE", e -> mainApp.showMedicinePage());
        initializeButton(fashion, "FASHION", e -> mainApp.showFashionPage());
        initializeButton(heathcare, "HEALTHCARE", e -> mainApp.showHealthCarePage());
        initializeButton(grooming, "GROOMING", e -> mainApp.showSalonPage());
        initializeButton(helpingHandButton, "HELPING HAND", e -> mainApp.showHelpingHandPage());
        initializeButton(profile, "PROFILE", e -> mainApp.showProfilePage());

        Image icon = new Image("com/project/assets/HeathImages/icons8-dog-64.png", 50, 50, true, false);
        ImageView iconImageView = new ImageView(icon);
        iconImageView.setLayoutX(50);
        Image ordericon = new Image("com\\project\\assets\\HeathImages\\ordericon.png", 30, 30, true, false);
        ImageView ordericonImageView = new ImageView(ordericon);
        ordericonImageView.setOnMouseClicked(event -> mainApp.showOrderPage());

        Label name = new Label("The Dog Hub");
        name.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));
        name.setPadding(new Insets(10, 0, 5, 0));
        name.setStyle(" -fx-text-fill: orange;");

        HBox searchBar = new HBox();
        searchBar.setAlignment(Pos.CENTER);
        searchBar.setSpacing(10);

        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(200);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            String query = searchField.getText();
            // Implement your search logic here
        });

        searchBar.getChildren().addAll(searchField, searchButton);

        HBox Bar = new HBox(10, iconImageView, name);
        Bar.setStyle("-fx-padding: 10;");
        Bar.setPadding(new Insets(5, 0, 5, 50));

        Button logout = new Button("About us");
        logout.setTextFill(Color.WHITE);
        logout.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 20));
        logout.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        logout.setOnMousePressed(event -> logout.setTextFill(Color.ORANGE));
        logout.setOnMouseReleased(event -> logout.setTextFill(Color.WHITE));
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainApp.showAboutUsPage();
            }
        });
       

        HBox orderBar = new HBox(50, searchBar, ordericonImageView, logout);
        orderBar.setStyle("-fx-padding: 10;");
        orderBar.setPadding(new Insets(17, 0, 5, 50));

        HBox logoBar = new HBox(1100, Bar, orderBar);
        logoBar.setStyle("-fx-padding: 10;");
        logoBar.setPadding(new Insets(5, 0, 5, 50));
        logoBar.setBackground(new Background(new BackgroundFill(Color.BLACK, null, new Insets(0, 0, 0, 0))));
        logoBar.setPrefHeight(60);

        HBox navBar1 = new HBox(50, home, dog, food, medicine, fashion, heathcare, grooming, helpingHandButton, profile);
        navBar1.setStyle("-fx-padding: 10;");
        navBar1.setPadding(new Insets(0, 0, 0, 20));
        navBar1.setBackground(new Background(new BackgroundFill(Color.web("#343333"), null, new Insets(0, 0, 0, 0))));
        navBar1.setPrefHeight(70);

        navbar.getChildren().addAll(logoBar, navBar1);
    }

    private void initializeButton(Button button, String text, EventHandler<ActionEvent> eventHandler) {
        button.setText(text);
        button.setTextFill(Color.WHITE);
        button.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 23));
        button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        button.setOnAction(e -> {
            eventHandler.handle(e);
            setActivePage(button);
        });
    }

    public VBox getNavbar() {
        return navbar;
    }

    // Method to set the active page and update button styles
    private void setActivePage(Button activeButton) {
        // Reset styles for all buttons
        home.setTextFill(Color.WHITE);
        dog.setTextFill(Color.WHITE);
        food.setTextFill(Color.WHITE);
        medicine.setTextFill(Color.WHITE);
        fashion.setTextFill(Color.WHITE);
        heathcare.setTextFill(Color.WHITE);
        grooming.setTextFill(Color.WHITE);
        helpingHandButton.setTextFill(Color.WHITE);
        profile.setTextFill(Color.WHITE);

        // Set the active button's style
        activeButton.setTextFill(Color.ORANGE);
    }
}
