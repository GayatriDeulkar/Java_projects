package com.project.OrderPageUI;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.Firestore;
import com.project.MainApp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrderPageUI {
    private static MainApp mainApp;
    static public List<Product> products = new ArrayList<>();
    static public Firestore firestore;
    Product product;
    private VBox cart;
    private static Stage primaryStage;
    

    public OrderPageUI(MainApp mainApp) {
        this.mainApp = mainApp;
        
    }

    // public VBox getOrderPage() {
    //     cart = new VBox();
    //     cart.setPadding(new Insets(10));
    //     cart.setSpacing(10);
    
    //     // Add initial product cards to the cart
    //     updateCartDisplay();
    
    //     // Wrap the cart in a ScrollPane if necessary
    //     ScrollPane scrollPane = new ScrollPane(cart);
    //     scrollPane.setFitToWidth(true);
    
    //     VBox root = new VBox(scrollPane);
    //     return root;
    // }
    

    // private void updateCartDisplay(VBox cart) {
    //     throw new UnsupportedOperationException("Unimplemented method 'updateCartDisplay'");
    // }

    

    public static  void showOrderDetails() {
        for (Product product : products) {
            firestore.collection("cart").document(product.getName()).set(product);
        }
       // OrderDetails orderDetails = new OrderDetails(products, primaryStage);
       OrderDetails orderDetails = new OrderDetails(products, primaryStage,mainApp);
       orderDetails.show();
    }

    // private void updateCartDisplay() {
    //     VBox cart = (VBox)((VBox) ((ScrollPane) primaryStage.getScene().getRoot()).getContent()).getChildren().get(0);
    //     cart.getChildren().clear();
    //     for (Product product : products) {
    //         VBox productBox = createProductBox(product);

    //         // Delete icon
    //         Image deleteIcon = new Image("file:demo\\deleteicon.png");
    //         ImageView deleteImageView = new ImageView(deleteIcon);
    //         deleteImageView.setFitWidth(20);
    //         deleteImageView.setFitHeight(20);
    //         deleteImageView.setOnMouseClicked(event -> {
    //             products.remove(product); // Remove product from list
    //             updateCartDisplay(); // Update UI to reflect changes
    //         });

    //         // Horizontal box to hold product details and delete icon
    //         HBox hb1 = new HBox(productBox);
    //         hb1.setAlignment(Pos.CENTER_LEFT);
    //         hb1.setSpacing(10);

    //         cart.getChildren().add(hb1);


    //     }               mainLayout.getChildren().remove(1);
    // }

    private void updateCartDisplay() {
        //VBox cart = (VBox) ((VBox) ((ScrollPane) primaryStage.getScene().getRoot()).getContent()).getChildren().get(0);
        cart.getChildren().remove(0);
        cart.getChildren().clear();
        for (Product product : products) {
            VBox productBox = createProductBox(product);

            // Delete icon
            Image deleteIcon = new Image("https://cdn-icons-png.flaticon.com/512/3405/3405244.png");
            ImageView deleteImageView = new ImageView(deleteIcon);
            deleteImageView.setFitWidth(20);
            deleteImageView.setFitHeight(20);
            deleteImageView.setOnMouseClicked(event -> {
                products.remove(product); // Remove product from list
                updateCartDisplay(); // Update UI to reflect changes
            });

            // Horizontal box to hold product details and delete icon
            HBox hb1 = new HBox(productBox);
            hb1.setAlignment(Pos.CENTER_LEFT);
            hb1.setSpacing(10);

            cart.getChildren().add(hb1);

        }
    }
    
    

    private VBox createProductBox(Product product) {
        Image image = new Image(product.getImgPath(),400,400,false,true);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(350);
        imageView.setPreserveRatio(true);

        VBox imageWrapper = new VBox();
        imageWrapper.setPadding(new Insets(10));
        imageWrapper.getChildren().add(imageView);

        Label titleLabel = new Label(product.getName());
        titleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");

        Label desLabel = new Label(product.getDescription());
        desLabel.setStyle("-fx-font-size: 18px;");

        Spinner<Integer> quantitySpinner = new Spinner<>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        quantitySpinner.setValueFactory(valueFactory);
        quantitySpinner.setStyle("-fx-pref-width: 60;");

        javafx.scene.control.Button incrementButton = new javafx.scene.control.Button("+");
        javafx.scene.control.Button decrementButton = new javafx.scene.control.Button("-");

        // Style the buttons to be smaller
        incrementButton.setStyle("-fx-font-size: 10px; -fx-pref-width: 30px; -fx-pref-height: 30px;");
        decrementButton.setStyle("-fx-font-size: 10px; -fx-pref-width: 30px; -fx-pref-height: 30px;");

        incrementButton.setOnAction(event -> {
            int currentValue = quantitySpinner.getValue();
            if (currentValue < 10) {
                quantitySpinner.getValueFactory().setValue(currentValue + 1);
            }
        });

        decrementButton.setOnAction(event -> {
            int currentValue = quantitySpinner.getValue();
            if (currentValue > 1) {
                quantitySpinner.getValueFactory().setValue(currentValue - 1);
            }
        });

        Label priceLabel = new Label("₹" + product.getPrice());
        priceLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Delete icon
        Image deleteIcon = new Image("https://cdn-icons-png.flaticon.com/512/3405/3405244.png");
        ImageView deleteImageView = new ImageView(deleteIcon);
        deleteImageView.setFitWidth(20);
        deleteImageView.setFitHeight(20);
        deleteImageView.setOnMouseClicked(event -> {
            products.remove(product); // Remove product from list
            updateCartDisplay(); // Update UI to reflect changes
        });

        VBox priceBox = new VBox(5, priceLabel, deleteImageView); // Add delete icon below price
        priceBox.setAlignment(Pos.CENTER_LEFT);

        VBox descriptionBox = new VBox(10, titleLabel, desLabel, quantitySpinner, priceBox);
        descriptionBox.setAlignment(Pos.TOP_LEFT);
        descriptionBox.setPadding(new Insets(20));
        descriptionBox.setStyle("-fx-background-color: white; -fx-border-width: 1; -fx-border-radius: 15;");

        HBox hb1 = new HBox(imageWrapper, descriptionBox);
        hb1.setPadding(new Insets(10));
        hb1.setStyle(
                "-fx-background-color: white; -fx-border-color: pink; -fx-border-width: 1; -fx-border-radius: 15;");

        VBox productBox = new VBox(10, hb1);
        productBox.setPrefWidth(1860);
        productBox.setPadding(new Insets(10));

        return productBox;
    }

    
    
    
    

   
    

    private void updateCartDisplay(VBox cart) {
        throw new UnsupportedOperationException("Unimplemented method 'updateCartDisplay'");
    }
    public  VBox getOrderPage() {
        VBox cart = new VBox(10);
        cart.setPadding(new Insets(10));
        System.out.println(products);
        for (Product product : products) {
            VBox productBox = createProductBox(product);

            // Delete icon
            Image deleteIcon = new Image("https://cdn-icons-png.flaticon.com/512/3405/3405244.png");
            ImageView deleteImageView = new ImageView(deleteIcon);
            deleteImageView.setFitWidth(20);
            deleteImageView.setFitHeight(20);
            deleteImageView.setOnMouseClicked(event -> {
                products.remove(product); // Remove product from list
                updateCartDisplay(cart); // Update UI to reflect changes
            });

            // Horizontal box to hold product details and delete icon
            HBox hb1 = new HBox(productBox);
            hb1.setAlignment(Pos.CENTER_LEFT);
            hb1.setSpacing(10);

            cart.getChildren().add(hb1);
        }

        // Checkout button
        Button checkoutButton = new Button("Place order");
        checkoutButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));
        checkoutButton.setStyle(
                "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 15px; -fx-border-radius: 15px;");
        checkoutButton.setPrefHeight(50);
        checkoutButton.setPrefWidth(300);
        //checkoutButton.setOnAction(event -> showOrderDetails());
        checkoutButton.setOnAction(event -> mainApp.showLoginPage());

        VBox dis = new VBox(10, cart, checkoutButton);
        dis.setAlignment(Pos.CENTER);

      

        ScrollPane sc = new ScrollPane(dis);
        VBox vb = new VBox(sc);
        return vb;
    }

    private static void showConfirmationPopup(Stage ownerStage) {
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

        Label messageLabel = new Label("    Congratulations,\n your order is Placed!\nDeliver within 24-48 hrs\nor you can even take your order from our offline store");
        messageLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 30));

        Button closeButton = new Button("OK");
        closeButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 20));
        closeButton.setStyle(
                "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 10px; -fx-border-radius: 10px;");
        closeButton.setOnAction(e -> popupStage.close());

        popupContent.getChildren().addAll(messageLabel, closeButton);

        // Set the content and show the popup
        Scene popupScene = new Scene(popupContent);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }

    // public void show() {
    //     primaryStage.setTitle("Product Cart");

    //     VBox cart = new VBox(10);
    //     cart.setPadding(new Insets(10));

    //     for (Product product : products) {
    //         VBox productBox = createProductBox(product);

    //         // Delete icon
    //         Image deleteIcon = new Image("file:demo\\deleteicon.png");
    //         ImageView deleteImageView = new ImageView(deleteIcon);
    //         deleteImageView.setFitWidth(20);
    //         deleteImageView.setFitHeight(20);
    //         deleteImageView.setOnMouseClicked(event -> {
    //             products.remove(product); // Remove product from list
    //             updateCartDisplay(); // Update UI to reflect changes
    //         });

    //         // Horizontal box to hold product details and delete icon
    //         HBox hb1 = new HBox(productBox);
    //         hb1.setAlignment(Pos.CENTER_LEFT);
    //         hb1.setSpacing(10);

    //         cart.getChildren().add(hb1);
    //     }

    //     // Checkout button
    //     Button checkoutButton = new Button("Checkout");
    //     checkoutButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));
    //     checkoutButton.setStyle(
    //             "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 15px; -fx-border-radius: 15px;");
    //     checkoutButton.setPrefHeight(50);
    //     checkoutButton.setPrefWidth(300);
    //     checkoutButton.setOnAction(event -> showOrderDetails());

    //     VBox dis = new VBox(10, cart, checkoutButton);
    //     dis.setAlignment(Pos.CENTER);

    //     // // Add the checkout button to the VBox
    //     // cart.getChildren().add(checkoutButton);
    //     // cart.setAlignment(Pos.CENTER);

    //     ScrollPane sc = new ScrollPane(dis);
    //     Scene scene = new Scene(sc, 1860, 900);
    //     primaryStage.setScene(scene);
    //     primaryStage.show();
    // }
}
