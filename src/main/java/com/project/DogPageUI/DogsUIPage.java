package com.project.DogPageUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.project.MainApp;
import com.project.ImageUploadBucket.ImageUploader;
import com.project.OrderPageUI.OrderPageUI;
import com.project.OrderPageUI.Product;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.WriteResult;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DogsUIPage {
    private GridPane gridPane;
    private int columnCount = 0;
    private int rowCount = 0;
    public static Firestore firestore;
    private MainApp mainApp;
    private String uploadedImageUrl;
    TextField docField;
    //private List<Product> cartProducts = new ArrayList<>();

    public DogsUIPage(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public VBox getDogPage() {

        VBox vbox = new VBox();
        

            // Create a BorderPane as the root node of the scene
            BorderPane borderPane = new BorderPane();

            // Add image at the top of the BorderPane
            Image sceneImage = new Image("com\\project\\assets\\HeathImages\\Dog_SALE.png");
            ImageView imageView = new ImageView(sceneImage);
            imageView.setFitWidth(1900); // Adjust width as needed
            imageView.setPreserveRatio(true); // Maintain aspect ratio
            Button add=new Button("ADD");
            add.setAlignment(Pos.CENTER);
            add.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 30));
            add.setOnAction(event -> {
                showDogAdminForm();
            });
            VBox vb=new VBox(imageView,add);
            vb.setAlignment(Pos.CENTER);
            borderPane.setTop(vb); // Set image at the top of the BorderPane

            // Center area for product boxes (GridPane)
            gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(5, 5, 5, 5));
            gridPane.setHgap(50);
            gridPane.setVgap(50);

            // Fetch and display products from Firestore
            try{
                fetchAndDisplayProducts();
            }catch(Exception e){
                e.printStackTrace();
            }

            ScrollPane scrollPane = new ScrollPane(borderPane);
            scrollPane.setFitToWidth(false);
            scrollPane.setFitToHeight(false);

            borderPane.setCenter(gridPane);
            // Set GridPane in the center of the BorderPane

            vbox = new VBox(scrollPane);


        
        return vbox;
    }

    private void addProductBox(VBox productBox) {
        if (columnCount == 4) {
            columnCount = 0;
            rowCount++;
        }

        gridPane.add(productBox, columnCount, rowCount);
        columnCount++;
    }

    private VBox createProductBox(String imgpath, String name, Long price,Long numberOfProducts, String description) {
        // System.out.println("ghjkjhgfdfghjkjhgfdfghj");
        // System.out.println(imgpath);
        VBox productBox = new VBox(10);
        productBox.setPadding(new Insets(10));
        productBox.setPrefSize(370, 50);

         // Create a DropShadow effect for the background glow
         DropShadow dropShadow = new DropShadow();
         dropShadow.setColor(Color.rgb(0, 0, 0, 0.5)); // Semi-transparent black glow
         dropShadow.setRadius(15);
         dropShadow.setSpread(0.2);
 
         // Add event handlers for hover to scale, translate, and add the glow effect
         productBox.setOnMouseEntered(event -> {
             productBox.setScaleX(1.05);
             productBox.setScaleY(1.05);
             productBox.setTranslateY(-5);
             productBox.setEffect(dropShadow);
         });
 
         productBox.setOnMouseExited(event -> {
             productBox.setScaleX(1.0);
             productBox.setScaleY(1.0);
             productBox.setTranslateY(0);
             productBox.setEffect(null);
         });
        

        // Add border to productBox
        productBox.setBorder(new Border(new BorderStroke(
                Color.LIGHTPINK, // Border color
                BorderStrokeStyle.SOLID, // Border style
                new CornerRadii(15), // Rounded corners
                new BorderWidths(2) // Border widths

        )));

        // Add shadow to the VBox
        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(15);
        shadow.setOffsetY(15);
        shadow.setColor(Color.GRAY);

        StackPane shadowWrapper = new StackPane(productBox);
        shadowWrapper.setEffect(shadow);
        shadowWrapper.setPadding(new Insets(5));
        // // // Image setup
        Image image = new Image(imgpath);
        System.out.println(image);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(350);
        imageView.setFitHeight(350);
        imageView.setPreserveRatio(false);

        Label nameLabel = new Label(name);
        nameLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));

        Text rs=new Text("Rs. ");
        rs.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 27));
        rs.setStyle("-fx-text-fill: navy;");
        Label priceLabel = new Label(Double.toString(price));
        priceLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 27));
        priceLabel.setStyle("-fx-text-fill: navy;");
        HBox hrs=new HBox(rs,priceLabel);


        Label descriptionLabel = new Label(description);
        descriptionLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 20));
        
        Label avi=new Label("Available item: ");
        avi.setStyle("-fx-text-fill: grey;");
        avi.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 20));
        Label availableitem = new Label(Long.toString(numberOfProducts));
        availableitem.setStyle("-fx-text-fill: grey;");
        availableitem.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 20));
        HBox aiHBox = new HBox(avi, availableitem);

        // Add to cart button
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));
        addToCartButton.setStyle(
                "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 15px; -fx-border-radius: 15px;");
        addToCartButton.setPrefWidth(500); // Set preferred width
        addToCartButton.setPrefHeight(50); // Set pre
        addToCartButton.setOnAction(e -> mainApp.showOrderPage());
        addToCartButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            addToCartButton.setStyle(
                    "-fx-background-color: #ef6c00; -fx-text-fill: black; -fx-background-radius: 15px; -fx-border-radius: 15px;");
        });
        addToCartButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            addToCartButton.setStyle(
                    "-fx-background-color: #ef6c00; -fx-text-fill: white; -fx-background-radius: 15px; -fx-border-radius: 15px;");
        });
        addToCartButton.setOnAction(event -> {
            // Add to cart action
            OrderPageUI.products.add(new Product(imgpath, name, price, description));
            // OrderPageUI.add(new Product(imgpath, name, price, description));
             System.out.println(name + " added to cart.");
        });


        VBox vb1 = new VBox(nameLabel, hrs,aiHBox);
        productBox.getChildren().addAll(imageView, vb1, addToCartButton);
        return productBox;
    }

    private void fetchAndDisplayProducts() throws InterruptedException, ExecutionException {
        QuerySnapshot querySnapshot = firestore.collection("dogs").get().get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

        for (QueryDocumentSnapshot document : documents) {


            
            String imgpath = document.getString("document");
            Long price = document.getLong("price");
            String name = document.getString("name");
            String description = document.getString("desc");
            Long numberOfProducts = document.getLong("nop");

            // System.out.println("name "+name);
            // System.out.println("price "+price);
            // System.out.println("nop "+numberOfProducts);
            // System.out.println("des  "+description);
            // System.out.println("path "+imgpath);


            addProductBox(createProductBox(imgpath, name, price,numberOfProducts ,description));
        }
    }

    
    private void showDogAdminForm() {
        Stage primaryStage=new Stage();
        ImageView imageView = new ImageView();
        
        Button uploadButton = new Button("Choose and Upload Image");
        


        // Set up the file chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpeg", "*.jpg")
        );

        // Set up the button action
        uploadButton.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                String imageUrl = ImageUploader.uploadImage(selectedFile.getPath(), selectedFile.getName());

                if (imageUrl != null) {
                    System.out.println(imageUrl);
                    uploadedImageUrl = imageUrl; // Save the URL for later use
                    Image image = new Image(imageUrl,150,150,false,false);
                    imageView.setImage(image);
                }
            }
        });

        // Layout
        VBox imageBox = new VBox(10, uploadButton, imageView);

        Label nameLabel = new Label("Enter Dog's Name:");
        nameLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        nameLabel.setStyle("-fx-text-fill: black;");
        TextField nameField = new TextField();
        nameField.setPrefWidth(300);

        Label nopLabel = new Label("Enter NOP:");
        nopLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        nopLabel.setStyle("-fx-text-fill: black;");
        TextField nopField = new TextField();
        nopField.setPrefWidth(300);

        Label priceLabel = new Label("Enter Price:");
        priceLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        priceLabel.setStyle("-fx-text-fill: black;");
        TextField priceField = new TextField();
        priceField.setPrefWidth(300);

        Label descriptionLabel = new Label("Enter Description:");
        descriptionLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        descriptionLabel.setStyle("-fx-text-fill: black;");
        TextArea descriptionField = new TextArea();
        descriptionField.setPrefWidth(300);
        descriptionField.setPrefHeight(100);

        
        Label docLabel = new Label("Enter Doc name:");
        docLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        docLabel.setStyle("-fx-text-fill: black;");
        docField = new TextField();
        docField.setPrefWidth(300);
        docField.setPrefHeight(100);

        Button submitButton = new Button("Submit");
        submitButton.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 20));
        submitButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String nopText = nopField.getText();
            String priceText = priceField.getText();
            String description = descriptionField.getText();
            String doc = docField.getText();

            if (name.isEmpty() || nopText.isEmpty() || priceText.isEmpty() || uploadedImageUrl == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill out all fields and upload an image.");
                alert.showAndWait();
            } else {
                try {
                    int nop = Integer.parseInt(nopText);
                    double price = Double.parseDouble(priceText);
                    saveDogAdminData(name, nop, price, description,doc,uploadedImageUrl);
                    primaryStage.close();
                    showInfoBox();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Form Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter valid numbers for NOP and Price.");
                    alert.showAndWait();
                }
            }
        });

        VBox formLayout = new VBox(10, imageBox, nameLabel, nameField, nopLabel, nopField, priceLabel, priceField, descriptionLabel, descriptionField,docLabel,docField, submitButton);
        formLayout.setPadding(new Insets(20, 250, 20, 250));
        formLayout.setAlignment(Pos.CENTER); 

         
          // Add the form layout to a ScrollPane
          ScrollPane scrollPane = new ScrollPane();
          scrollPane.setContent(formLayout);
          scrollPane.setFitToWidth(true);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("https://img.freepik.com/free-photo/cute-dog-with-costume-copy-space_23-2148865705.jpg", 1000, 1000, false, false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        formLayout.setBackground(new Background(backgroundImage));

        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(scrollPane);
        
        Scene formScene = new Scene(rootPane, 1000, 1000);
        primaryStage.setScene(formScene);
        primaryStage.show();
    }

    private void saveDogAdminData(String name, int nop, double price, String description, String imageUrl,String doc) {
        Map<String, Object> dogAdminData = new HashMap<>();
        dogAdminData.put("name", name);
        dogAdminData.put("nop", nop);
        dogAdminData.put("price", price);
        dogAdminData.put("desc", description);
        dogAdminData.put("image", imageUrl);
        dogAdminData.put("document", doc);

        ApiFuture<WriteResult> future = firestore.collection("dogs").document(docField.getText()).set(dogAdminData);
        try {
            future.get();
            System.out.println("Dog admin data successfully saved!");
        } catch (Exception e) {
            System.err.println("Error saving dog admin data: " + e.getMessage());
        }
    }

    private void showInfoBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Data uploaded successfully!");
        alert.showAndWait();
    }
    
    
}
