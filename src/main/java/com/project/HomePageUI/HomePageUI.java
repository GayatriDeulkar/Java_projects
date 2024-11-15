package com.project.HomePageUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

import com.project.MainApp;

public class HomePageUI {

    private MainApp mainApp;

    public HomePageUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public VBox getHomePage() {
        VBox homepageLayout = new VBox(20);
        homepageLayout.setAlignment(Pos.CENTER);
        homepageLayout.setPadding(new Insets(0, 20, 20, 20));

        // // Add the scrolling images at the top
        // HBox imageContainer = new HBox(10); // 10 is the spacing between images
        // imageContainer.setAlignment(Pos.CENTER);

        // ArrayList<Image> images = new ArrayList<>();
        // images.add(new Image("https://headsupfortails.com/cdn/shop/files/Personalised_web_2c242393-4ca3-46f6-aadc-72ef734b1889.webp?v=1718861889"));
        // images.add(new Image("https://supertails.com/cdn/shop/files/1July_Henlo_Main-min_1600x.png?v=1720085628"));
        // images.add(new Image("https://supertails.com/cdn/shop/files/Des-2_4959ee65-d96d-437c-871e-61a4522f8de1_1600x.png?v=1717598079"));
        // images.add(new Image("https://cdn.shopify.com/s/files/1/0565/8021/0861/files/Des_1a81746d-6409-460f-8a27-a4736004477a.png?v=1720000119"));
        // images.add(new Image("https://media.istockphoto.com/id/508260842/photo/group-of-chihuahuas-dressed-wearing-glasses-and-bow-ties.jpg?s=612x612&w=0&k=20&c=7Juzoz9ft5vCB-IxVrSAWf2K72RLMkVuTEaedygvrJ0="));
        

        // for (Image image : images) {
        //     ImageView imageView = new ImageView(image);
        //     imageView.setFitHeight(300); // Set desired height
        //     imageView.setPreserveRatio(true);
        //     imageContainer.getChildren().add(imageView);
        // }

        // // Create a ScrollPane for the horizontal scrolling images
        // ScrollPane imageScrollPane = new ScrollPane();
        // imageScrollPane.setContent(imageContainer);
        // imageScrollPane.setFitToHeight(true);
        // imageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Show horizontal scrollbar only when needed
        // imageScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Hide the vertical scrollbar
        // imageScrollPane.setPrefWidth(1860); // Set the preferred width for the ScrollPane
        // // Hide the horizontal scrollbar
        // imageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        // Add the ScrollPane to the top of the VBox


        String videoPath = "E:\\core2web\\java_project\\MAVEN_PROJECTS\\thedoghub\\src\\main\\java\\com\\project\\assets\\HeathImages\\dogPlayingvideo.mp4";
            File videoFile = new File(videoPath);
            String fileURI = videoFile.toURI().toString();

        Media media = new Media(fileURI);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(1860);
        mediaView.setFitHeight(400);
        mediaView.setPreserveRatio(false);

        mediaPlayer.setAutoPlay(true); // Start playing the video automatically

          // Set the media player to loop the video
          mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        homepageLayout.getChildren().add(mediaView);

        Image topImage = new Image("com/project/assets/HomePageImages/unbeatabledeals1.png", 1860, 0, true, false);
        ImageView topImageView = new ImageView(topImage);
        // topImageView.setFitWidth(1850); // Set desired width
        // topImageView.setFitHeight(530); // Set desired height
        topImageView.setPreserveRatio(true);

        Button shopNow = new Button("Shop Now");
        shopNow.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        shopNow.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        shopNow.setPrefSize(220, 50);
        shopNow.setLayoutX(410);
        shopNow.setLayoutY(300);
        shopNow.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            shopNow.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:black");
        });
        shopNow.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            shopNow.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:white");
        });
        shopNow.setOnAction(e -> mainApp.showDogsPage());
        Pane p1 = new Pane(topImageView, shopNow);

        
        homepageLayout.getChildren().add(p1);

        // Add text below the scrolling images
        Text headerText = new Text("Dog Categories for Sale :)");
        headerText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(headerText);

        // Add dog image below the text
        Image dogImage = new Image("com/project/assets/HomePageImages/dogvar.png", 1860, 0, true, false);
        ImageView dogImageView = new ImageView(dogImage);
        dogImageView.setPreserveRatio(true);

        dogImageView.setOnMouseClicked(event -> {
            mainApp.showDogsPage();
        });

        homepageLayout.getChildren().add(dogImageView);

        // Add an image below the dog image (as before)
        Image belowCheckoutImage = new Image("com/project/assets/HomePageImages/clothes.png", 1860, 300, false, false);
        ImageView belowCheckoutImageView = new ImageView(belowCheckoutImage);
        belowCheckoutImageView.setPreserveRatio(true);

        // Set up the image to behave like a button
        belowCheckoutImageView.setOnMouseClicked(event -> {
            // Handle the click event here, e.g., navigate to another page
        });

        homepageLayout.getChildren().add(belowCheckoutImageView);

        // Add text "Get clothes for your pet" below the image
        Text clothesText = new Text("Get clothes for your pet!");
        clothesText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(clothesText);

        // Add an image below the text (as before)
        Image additionalImage = new Image("com/project/assets/HomePageImages/clothimg.png", 1860, 300, true, false);
        ImageView additionalImageView = new ImageView(additionalImage);
        additionalImageView.setOnMouseClicked(event -> {
            mainApp.showFashionPage();
        });
        additionalImageView.setPreserveRatio(true);

        homepageLayout.getChildren().add(additionalImageView);

        // Add an image below the dog image (as before)
        Image foodImage = new Image("com/project/assets/HomePageImages/food2.png", 1860, 0, true, false);
        ImageView foodImageView = new ImageView(foodImage);
        foodImageView.setOnMouseClicked(event -> {
            mainApp.showFoodPage();
        });

        homepageLayout.getChildren().add(foodImageView);

        // Add text "Lets Give Your Pet Yummy Food!" below the image
        Text foodText = new Text("Lets Give Your Pet Yummy Food!");
        foodText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(foodText);

        // Add an image below the dog image (as before)
        Image food1Image = new Image("com/project/assets/HomePageImages/food1.png", 1860, 300, true, false);
        ImageView food1ImageView = new ImageView(food1Image);
        food1ImageView.setOnMouseClicked(event -> {
            mainApp.showFoodPage();
        });
        homepageLayout.getChildren().add(food1ImageView);

        Text healthText = new Text("Lets Make Your Pet Helthy <3");
        healthText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(healthText);

        // Add an image below the dog image (as before)
        Image helthImage = new Image("com/project/assets/HomePageImages/health.png", 1860, 450, false, false);
        ImageView helthImageView = new ImageView(helthImage);
        helthImageView.setOnMouseClicked(event -> {
            mainApp.showMedicinePage();
        });
        homepageLayout.getChildren().add(helthImageView);

        // Add text "Lets Make Your Pet Helthy <3" below the image
        

        // //Add an image below the dog image (as before)
        // Image helth1Image = new Image("com/project/assets/HomePageImages/health1.png", 1860, 350, false, false);
        // ImageView helth1ImageView = new ImageView(helth1Image);
        // helth1ImageView.setPreserveRatio(true);
        // homepageLayout.getChildren().add(helth1ImageView);

        Text salonText = new Text("Lets Get Your Pet groomed!");
        salonText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(salonText);

        // Add an image below the dog image (as before)
        Image salonImage = new Image("com/project/assets/HomePageImages/salon.png", 1860, 500, false, false);
        ImageView salonImageView = new ImageView(salonImage);
        salonImageView.setOnMouseClicked(event -> {
            mainApp.showSalonPage();
        });
        homepageLayout.getChildren().add(salonImageView);

        // Add an image below the dog image (as before)
        Image doctorImage = new Image("com/project/assets/HomePageImages/doctor.jpeg", 1860, 500, true, false);
        ImageView doctorImageView = new ImageView(doctorImage);
        doctorImageView.setPreserveRatio(true);

        Button explore = new Button("Explore Now");
        explore.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        explore.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        explore.setPrefSize(300, 50);
        explore.setLayoutX(310);
        explore.setLayoutY(290);
        explore.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            explore.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:black");
        });
        explore.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            explore.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:white");
        });

        Text donateText = new Text("Donate for Street Dogs <3");
        donateText.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        homepageLayout.getChildren().add(donateText);

        // Add an image below the dog image (as before)
        Image streetdogImage = new Image("com/project/assets/HomePageImages/strdog.png", 1860, 700, true, false);
        ImageView streetdogImageView = new ImageView(streetdogImage);
        streetdogImageView.setPreserveRatio(true);

        Button helpButton = new Button("Donate for them");
        helpButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        helpButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        helpButton.setPrefSize(300, 50);
        helpButton.setLayoutX(750);
        helpButton.setLayoutY(450);
        helpButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            helpButton.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:black");
        });
        helpButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            helpButton.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:white");
        });
        helpButton.setOnAction(e -> mainApp.showHelpingHandPage());

        Pane helpPane = new Pane(streetdogImageView, helpButton);
        Pane p2 = new Pane(doctorImageView, explore, helpPane);
        homepageLayout.getChildren().add(p2);

        // Create a ScrollPane to make the VBox scrollable
        ScrollPane mainScrollPane = new ScrollPane();
        mainScrollPane.setContent(homepageLayout);
        mainScrollPane.setPrefSize(1950, 980);

        // Add the ScrollPane to the scene
        VBox vBox = new VBox(mainScrollPane);

        // // Optional: Add auto-scrolling for the horizontal image scroll
        // startAutoScroll(imageScrollPane, 50); // Adjust the speed as needed

        return vBox;
    }

    private void startAutoScroll(ScrollPane scrollPane, int speed) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed), event -> {
            scrollPane.setHvalue(scrollPane.getHvalue() + 0.001); // Scroll by 1% of the width
            if (scrollPane.getHvalue() >= 1) {
                scrollPane.setHvalue(0); // Reset to the start
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
