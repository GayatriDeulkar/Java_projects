package com.project.AfterLoginProfileUI;

import com.project.MainApp;

import javafx.event.EventHandler;
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
import javafx.scene.text.Text;

public class AfterLoginProfileUI {
    private MainApp mainApp;

    public AfterLoginProfileUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    public VBox getAfterLoginProfileUI(){

        Image loginSignupBackgroundImage=new Image("com\\project\\assets\\HeathImages\\loginbackground.jpg",1940,860,false,false);
        ImageView backImageView=new ImageView(loginSignupBackgroundImage);
        Label lb1=new Label("Profile Infomation");
        lb1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 43));
        lb1.setStyle(" -fx-text-fill: white;");
        lb1.setLayoutX(120);
        lb1.setLayoutY(50);

        Label yourname=new Label("Name");
        yourname.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        yourname.setStyle(" -fx-text-fill: white;");
        yourname.setLayoutX(100);
        yourname.setLayoutY(130);
        Text yournames=new Text("Abc Xyz");
        yournames.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 25));
        yournames.setStyle(" -fx-text-fill: white;");
        yournames.setLayoutX(100);
        yournames.setLayoutY(150);
        
        Text youremails=new Text("Email");
        youremails.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        youremails.setStyle(" -fx-text-fill: white;");
        youremails.setLayoutX(100);
        youremails.setLayoutY(200);
        Text youremail=new Text("abc.com");
        youremail.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 25));
        youremail.setStyle(" -fx-text-fill: white;");
        youremail.setLayoutX(100);
        youremail.setLayoutY(220);

        Label yourmob=new Label("Mobile No.");
        yourmob.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        yourmob.setStyle(" -fx-text-fill: white;");
        yourmob.setLayoutX(100);
        yourmob.setLayoutY(270);
        Text mobFields=new Text("345678987654");
        mobFields.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 25));
        mobFields.setStyle(" -fx-text-fill: white;");
        mobFields.setLayoutX(100);
        mobFields.setLayoutY(290);
        


        Label info=new Label("shipping information");
        info.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 25));
        info.setStyle(" -fx-text-fill: white;");
        info.setLayoutX(100);
        info.setLayoutY(420);

        Label address=new Label("Shipping address");
        address.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 15));
        address.setStyle(" -fx-text-fill: white;");
        address.setLayoutX(100);
        address.setLayoutY(470);
        Text shippaddressField=new Text("pune 4 block C ,pune");
        shippaddressField.setFont(Font.font("Trebuchet MS",FontWeight.MEDIUM, 25));
        shippaddressField.setStyle(" -fx-text-fill: white;");
        shippaddressField.setLayoutX(100);
        shippaddressField.setLayoutY(490);

        

        Button createAccButton = new Button("Edit");
        createAccButton.setPrefSize(200, 25);
        createAccButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 19));
        createAccButton.setStyle(" -fx-background-color: #ef6c00; -fx-text-fill: white;");
        createAccButton.setLayoutX(190);
        createAccButton.setLayoutY(620);
        createAccButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            createAccButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
        });

        createAccButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            createAccButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        });

        





        Pane pn=new Pane(backImageView,lb1,yourname,yournames,youremails,youremail,yourmob,mobFields,info,address,shippaddressField,createAccButton);
        VBox vBox=new VBox(pn);
        ScrollPane scrollPane=new ScrollPane(vBox);
        scrollPane.setPrefSize(1950, 980);

        VBox vb=new VBox(scrollPane);
        return vb;
    }
}
