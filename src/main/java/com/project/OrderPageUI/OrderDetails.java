
package com.project.OrderPageUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

import com.project.MainApp;



public class OrderDetails {

    private List<Product> products;
    private MainApp mainApp;
    // private Stage primaryStage;

    public OrderDetails(List<Product> products, Stage primaryStage,MainApp mainApp) {
        this.products = products;
        this.mainApp = mainApp;
        // this.primaryStage = primaryStage;
    }

    public void show() {
        // Create a new stage for Order Details
        Stage orderStage = new Stage();
        orderStage.initModality(Modality.APPLICATION_MODAL);
        orderStage.initStyle(StageStyle.UNDECORATED);

        VBox orderDetails = new VBox(10);
        orderDetails.setPadding(new Insets(10));
        orderDetails.setMaxWidth(800);
        orderDetails.setMaxHeight(600);

        // Set the background image
        Image backgroundImage = new Image("https://images.rawpixel.com/image_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTA0L2pvYjE4MjktYmFja2dyb3VuZC1ib29tLTA0YS5qcGc.jpg", 0, 1000, true,
                false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        orderDetails.setBackground(new Background(background));

        // Product details and total price section
        VBox productDetailsBox = new VBox(20);
        productDetailsBox.setPrefSize(500, 500);
        productDetailsBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 15;");
        productDetailsBox.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Order Details");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        productDetailsBox.getChildren().add(titleLabel);

        double totalPrice = 0;

        for (Product product : products) {
            HBox productRow = new HBox(30);
            productRow.setAlignment(Pos.CENTER);

            VBox name = new VBox(20);
            name.setAlignment(Pos.CENTER);
            Label nameLabel = new Label(product.getName());
            nameLabel.setStyle("-fx-font-size: 20px;");
            name.getChildren().add(nameLabel);

            VBox pric = new VBox(20);
            pric.setAlignment(Pos.CENTER);
            Label priceLabel = new Label("₹" + product.getPrice());
            priceLabel.setStyle("-fx-font-size: 20px;");
            pric.getChildren().add(priceLabel);

            productRow.getChildren().addAll(name, pric);
            productDetailsBox.getChildren().add(productRow);

            totalPrice += product.getPrice();
        }

        Label DeliveryLabel = new Label("Delivery Charges:      Free");
        DeliveryLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        productDetailsBox.getChildren().add(DeliveryLabel);

        Label totalPriceLabel = new Label("Total Price:      ₹" + totalPrice);
        totalPriceLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        productDetailsBox.getChildren().add(totalPriceLabel);

        // Payment options section
        VBox paymentOptionsBox = new VBox(20);
        paymentOptionsBox.setPrefSize(500, 500);
        paymentOptionsBox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 15;");
        paymentOptionsBox.setAlignment(Pos.CENTER);

        Label paymentOptionsLabel = new Label("More ways to pay online");
        paymentOptionsLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ff0000;");
        paymentOptionsBox.getChildren().add(paymentOptionsLabel);

        ToggleGroup paymentOptionsGroup = new ToggleGroup();

        // Phone Pay option
        Image phonePayIcon = new Image("com/project/assets/salonimage/phonepay.png");
        ImageView phonePayImageView = new ImageView(phonePayIcon);
        phonePayImageView.setFitWidth(40);
        phonePayImageView.setFitHeight(40);
        RadioButton phonePayOption = new RadioButton("Phone Pay");
        phonePayOption.setStyle("-fx-font-size: 18px;");
        phonePayOption.setToggleGroup(paymentOptionsGroup);
        HBox phonePayBox = new HBox(5, phonePayImageView, phonePayOption);
        phonePayBox.setPadding(new Insets(20));

        // GPay option
        Image gPayIcon = new Image("com\\project\\assets\\salonimage\\gpay.png");
        ImageView gPayImageView = new ImageView(gPayIcon);
        gPayImageView.setFitWidth(40);
        gPayImageView.setFitHeight(40);
        RadioButton gPayOption = new RadioButton("GPay");
        gPayOption.setStyle("-fx-font-size: 18px;");
        gPayOption.setToggleGroup(paymentOptionsGroup);
        HBox gPayBox = new HBox(5, gPayImageView, gPayOption);
        gPayBox.setPadding(new Insets(20));

        // Amazon Pay option
        Image amazonPayIcon = new Image("com\\project\\assets\\salonimage\\amazonpay.png");
        ImageView amazonPayImageView = new ImageView(amazonPayIcon);
        amazonPayImageView.setFitWidth(40);
        amazonPayImageView.setFitHeight(40);
        RadioButton amazonPayOption = new RadioButton("Amazon Pay");
        amazonPayOption.setStyle("-fx-font-size: 18px;");
        amazonPayOption.setToggleGroup(paymentOptionsGroup);
        HBox amazonPayBox = new HBox(5, amazonPayImageView, amazonPayOption);
        amazonPayBox.setPadding(new Insets(20));

        Label codLabel = new Label("Cash on Delivery");
        codLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ff0000;");

        // Cash on Delivery option
        Image codIcon = new Image("com\\project\\assets\\salonimage\\cod.jpg");
        ImageView codImageView = new ImageView(codIcon);
        codImageView.setFitWidth(40);
        codImageView.setFitHeight(40);
        RadioButton codOption = new RadioButton("Cash on Delivery");
        codOption.setStyle("-fx-font-size: 18px;");
        codOption.setToggleGroup(paymentOptionsGroup);
        HBox codBox = new HBox(5, codImageView, codOption);
        codBox.setPadding(new Insets(15));

        paymentOptionsBox.getChildren().addAll(phonePayBox, gPayBox, amazonPayBox);
        paymentOptionsBox.getChildren().add(codLabel);
        paymentOptionsBox.getChildren().add(codBox);

        // Combine product details and payment options into one HBox
        HBox contentBox = new HBox(20);
        contentBox.getChildren().addAll(productDetailsBox, paymentOptionsBox);
        contentBox.setAlignment(Pos.TOP_CENTER);

        // Add to cart button at the bottom
        Button orderButton = new Button("Confirm Order");
        orderButton.setAlignment(Pos.CENTER);
        orderButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 20));
        orderButton.setStyle(
                "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 15px; -fx-border-radius: 20px;");
        orderButton.setPrefWidth(200); // Set preferred width
        orderButton.setPrefHeight(50); // Set preferred height
        orderButton.setOnAction(event -> {
            // Navigate to cart page
            showConfirmationPopup(orderStage); // Pass orderStage to confirmation popup
            orderStage.close();
        });

        // Add contentBox to orderDetails VBox
        orderDetails.getChildren().addAll(contentBox, orderButton);
        orderDetails.setAlignment(Pos.BOTTOM_CENTER);

        Scene orderDetailsScene = new Scene(orderDetails, 1000, 1000);
        orderStage.setTitle("Product Page");
        orderStage.setScene(orderDetailsScene);
        orderStage.show();
    }

    private void showConfirmationPopup(Stage ownerStage) {
        // Create a new stage for the popup
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(ownerStage); // Set owner for proper modality
        popupStage.initStyle(StageStyle.UNDECORATED);

        // Create the confirmation message
        VBox popupContent = new VBox(20);
        popupContent.setPrefSize(500, 500);
        popupContent.setAlignment(Pos.CENTER);
        popupContent.setPadding(new Insets(20));
        popupContent.setStyle(
                "-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2px;-fx-border-radius: 15;");

        Label messageLabel = new Label("            Congratulations,\n      your order is Placed!\n   Deliver within 24-48 hrs\nor you can even take your order\n     from our offline store");
        messageLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 30));

        Button closeButton = new Button("OK");
        closeButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 20));
        closeButton.setStyle(
                "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        closeButton.setOnAction(
            e -> {popupStage.close();
                mainApp.showHomePage();
            }
            
            );

        popupContent.getChildren().addAll(messageLabel, closeButton);

        // Set the content and show the popup
        Scene popupScene = new Scene(popupContent);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }
}
