package com.project.Abouus;

import com.project.MainApp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AboutUsPageUI {
    private MainApp mainApp;

    public AboutUsPageUI(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public VBox getAbouUsPage() {

                HBox aboutusBox = new HBox(15);

                Image SirImage = new Image(
                                "com\\project\\assets\\salonimage\\shashi_sir_Image.jpg",
                                500, 500, true, true);
                ImageView imageView = new ImageView(SirImage);

                // Create the main VBox for the About Us page
                VBox UsBox = new VBox(15);
                UsBox.setPrefSize(1400, 1000);
                UsBox.setPadding(new Insets(10));
                UsBox.setAlignment(Pos.CENTER);

                // Title
                Label titleLabel = new Label("About Us");
                titleLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 42));
                titleLabel.setTextFill(Color.MAROON);
                UsBox.getChildren().add(titleLabel);

                // Project Information
                Label projectInfoLabel = new Label("Project Information:\n" +
                                "This project is designed to demonstrate a functional online ordering system\n " +
                                "using JavaFX for the user interface. The application allows users to browse products,\n "
                                +
                                "book appointments,view order details, select payment options, and place orders.");
                projectInfoLabel.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 25));
                projectInfoLabel.setWrapText(true);
                UsBox.getChildren().add(projectInfoLabel);

                // Group Members
                Label groupMembersLabel = new Label("Group Members:\n" +
                                "1. Laxmi Borse\n" +
                                "2. Gayatri Deulkar\n" +
                                "3. Aakansha Kalukhe");
                groupMembersLabel.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 25));
                groupMembersLabel.setWrapText(true);
                UsBox.getChildren().add(groupMembersLabel);

                // Guide
                Label guideLabel = new Label("Guide:Mr.Pramod Sir");
                guideLabel.setFont(Font.font("Trebuchet MS", FontWeight.NORMAL, 25));
                guideLabel.setWrapText(true);
                UsBox.getChildren().add(guideLabel);


                Label thankYouLabel = new Label("Special Thank You!\n\n" +
                                " Sachin Sir,\n " +
                                "Subodh Sir,\n " +
                                "Shiv Sir,\n\n " +
                                "Thanks to all of You!,\n " +
                                "We appreciate your interest in our project. For more information, " +
                                "feel free to reach out to us.\n\n" +
                                "Thank you so much Shashi Sir to providing us such a huge platform.\n\n" +
                                "Shop Address:\n" +
                                "3rd Floor, Walhekar Properties, Core2web Technologies,\n Narhe, above HDFC Bank, Narhe, Pune, Maharashtra 411041");
                thankYouLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 25));
                thankYouLabel.setWrapText(true);
                UsBox.getChildren().add(thankYouLabel);

                aboutusBox.getChildren().addAll(UsBox, imageView);
                VBox vb =new VBox(aboutusBox);
                return vb;
        }
}
    

