package com.project.HelpingHandpageUI;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.FileOutputStream;

import com.project.MainApp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelpingHand {
    private MainApp mainApp;

    public HelpingHand(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public VBox getHelpingHandPage() {

        Label quote =new Label(" Every small act of kindness towards a street dog is a giant\n step towards a compassionate world. Your donation can\n change their lives, offering them love, care, and a chance\n at a better future.Together, we can make a difference—one\n paw at a time.");
        quote.setLayoutX(1100);
        quote.setLayoutY(50);
        quote.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 28));
        quote.setStyle("-fx-text-fill: white;");

        Image streetdog=new Image("com\\project\\assets\\HeathImages\\streetdog.png",1950,850,false,false);
        ImageView streetdogiv=new ImageView(streetdog);
        Image qr=new Image("com\\project\\assets\\HeathImages\\donateQR.png",350,350,true,false);
        ImageView qriv=new ImageView(qr);
        qriv.setLayoutX(1300);
        qriv.setLayoutY(250);

        Button donate = new Button("Download and Scan me");
    donate.setFont(Font.font("Trebuchet MS",FontWeight.BOLD, 27));
    donate.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
    donate.setPrefSize(350, 30);
    donate.setLayoutX(1300);
    donate.setLayoutY(650);
    donate.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
        donate.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;");
    });
    donate.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
        donate.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
    });

    donate.setOnAction(event -> {
        downloadImage("com/project/assets/HeathImages/qr.png");
    });
        Pane pn=new Pane(streetdogiv,qriv,donate,quote);
        VBox vbox = new VBox(pn);
        return vbox;
    }

    private void downloadImage(String imagePath) {
        // Obtain the image from resources
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream(imagePath);
        if (imageStream == null) {
            showAlert("Error", "Image not found: " + imagePath, AlertType.ERROR);
            return;
        }

        // Create a file chooser to let the user select the destination
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));

        // Show the save dialog
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            try (FileOutputStream outputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = imageStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                showAlert("Success", "Image saved to: " + file.getAbsolutePath(), AlertType.INFORMATION);
            } catch (Exception e) {
                showAlert("Error", "Failed to save image: " + e.getMessage(), AlertType.ERROR);
            }
        }
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}