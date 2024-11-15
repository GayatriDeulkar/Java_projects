package com.project.FormUponGetAppoint;

import com.project.MainApp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class FormUponGetAppo {
    private MainApp mainApp;

    public FormUponGetAppo(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public VBox createDogDetailsForm() {
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label mobileLabel = new Label("Mobile Number:");
        TextField mobileField = new TextField();

        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        VBox form = new VBox(10);
        form.setPadding(new Insets(10));
        form.getChildren().addAll(
            nameLabel, nameField,
            mobileLabel, mobileField,
            genderLabel, maleRadio, femaleRadio,
            ageLabel, ageField
        );

        form.setPrefSize(600, 600);
        form.setMaxSize(600, 600);
        form.setMinSize(600, 600);
        form.setStyle("-fx-border-color: gray; -fx-border-width: 1px; -fx-padding: 10px; -fx-background-color: rgba(255, 255, 255, 0.8);");

        // Adding background image
        BackgroundImage backgroundImage = new BackgroundImage(
            new Image("com\\project\\assets\\HeathImages\\streetdog.png"),
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        form.setBackground(new Background(backgroundImage));

        return form;
    }
}
