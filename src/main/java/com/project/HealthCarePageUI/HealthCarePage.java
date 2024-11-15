package com.project.HealthCarePageUI;

import com.google.cloud.firestore.Firestore;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.project.MainApp;
import com.project.fireConfig.dataService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class HealthCarePage {
    private MainApp mainApp;
    private Firestore firestore;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private Label totalAmountLabel;

    public HealthCarePage(MainApp mainApp) {
        this.mainApp = mainApp;
        this.firestore = dataService.db;
    }

    public VBox getHealthCarePage() {
        Button bookAppointment = new Button("Book Appointment");
        bookAppointment.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        bookAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        bookAppointment.setPrefSize(400, 50);
        bookAppointment.setLayoutX(240);
        bookAppointment.setLayoutY(350);
        bookAppointment.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> bookAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;"));
        bookAppointment.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> bookAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;"));
        bookAppointment.setOnAction(event -> showForm());

        Button getAppointment = new Button("Get Appointment");
        getAppointment.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        getAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        getAppointment.setPrefSize(400, 50);
        getAppointment.setLayoutX(270);
        getAppointment.setLayoutY(200);
        getAppointment.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> getAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;"));
        getAppointment.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> getAppointment.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;"));
        getAppointment.setOnAction(event -> mainApp.showFormPage());
        getAppointment.setOnAction(event -> showForm());
        
        

        Button buyFoodButton = new Button("Buy Food");
        buyFoodButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        buyFoodButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        buyFoodButton.setPrefSize(300, 50);
        buyFoodButton.setLayoutX(460);
        buyFoodButton.setLayoutY(270);
        buyFoodButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> buyFoodButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;"));
        buyFoodButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> buyFoodButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;"));
        buyFoodButton.setOnAction(e -> mainApp.showFoodPage());

        Button buyMedicineButton = new Button("Buy Medicine");
        buyMedicineButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        buyMedicineButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        buyMedicineButton.setPrefSize(300, 50);
        buyMedicineButton.setLayoutX(460);
        buyMedicineButton.setLayoutY(270);
        buyMedicineButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> buyMedicineButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: black;"));
        buyMedicineButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> buyMedicineButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;"));
        buyMedicineButton.setOnAction(e -> mainApp.showMedicinePage());

        Image i1 = new Image("com\\project\\assets\\HeathImages\\doctor.png", 960, 770, false, false);
        ImageView iv1 = new ImageView(i1);
        Pane p1 = new Pane(iv1, getAppointment);
        Image i2 = new Image("com\\project\\assets\\HeathImages\\diet.png", 930, 370, false, false);
        ImageView iv2 = new ImageView(i2);
        Pane p2 = new Pane(iv2, buyFoodButton);
        Image i3 = new Image("com\\project\\assets\\HeathImages\\medicine.png", 930, 395, false, false);
        ImageView iv3 = new ImageView(i3);
        Pane p3 = new Pane(iv3, buyMedicineButton);
        Image i4 = new Image("com\\project\\assets\\HeathImages\\firstImage.png", 1900, 700, false, false);
        ImageView iv4 = new ImageView(i4);
        Pane p4 = new Pane(iv4, bookAppointment);
        Image i5 = new Image("com\\project\\assets\\HeathImages\\sidebar2.png", 1900, 700, true, false);
        ImageView iv5 = new ImageView(i5);

        VBox v1 = new VBox(5, p2, p3);
        v1.setPadding(new Insets(10));
        HBox h1 = new HBox(p1, v1);
        h1.setAlignment(Pos.CENTER);

        Label general = new Label("General Veterinary Check-Up");
        general.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        general.setStyle(" -fx-text-fill: black;");
        Label generaldesc = new Label("Price Range: $50 - $100\nDescription: A routine examination to assess your\n dog's overall health, including physical examination\n and basic diagnostics.");
        generaldesc.setFont(Font.font("Trebuchet MS", 17));
        generaldesc.setStyle(" -fx-text-fill: grey;");
        VBox vb1 = new VBox(10, general, generaldesc);

        Label vaccinations = new Label("Vaccination");
        vaccinations.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        vaccinations.setStyle(" -fx-text-fill: black;");
        Label vacdesc = new Label("Price Range: $20 - $50 per vaccine\nDescription: Essential vaccinations like rabies, distemper,\n parvovirus, and others to prevent common\n diseases.");
        vacdesc.setFont(Font.font("Trebuchet MS", 17));
        vacdesc.setStyle(" -fx-text-fill: grey;");
        VBox vb2 = new VBox(10, vaccinations, vacdesc);

        Label spaying = new Label("Spaying/Neutering");
        spaying.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        spaying.setStyle(" -fx-text-fill: black;");
        Label sprayingdesc = new Label("Price Range: $200 - $500\nDescription: Surgical procedures to sterilize dogs, preventing \nunwanted breeding and certain health issues.");
        sprayingdesc.setFont(Font.font("Trebuchet MS", 17));
        sprayingdesc.setStyle(" -fx-text-fill: grey;");
        VBox vb3 = new VBox(10, spaying, sprayingdesc);

        Label dental = new Label("Dental Cleaning");
        dental.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        dental.setStyle(" -fx-text-fill: black;");
        Label dentaldesc = new Label("Price Range: $100 - $300\nDescription: Professional cleaning to prevent dental disease,\n including scaling and polishing of teeth.");
        dentaldesc.setFont(Font.font("Trebuchet MS", 17));
        dentaldesc.setStyle(" -fx-text-fill: grey;");
        VBox vb4 = new VBox(10, dental, dentaldesc);

        Label emergency = new Label("Emergency Care");
        emergency.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        emergency.setStyle(" -fx-text-fill: black;");
        Label emergencydesc = new Label("Price Range: $100 - $1,000+\nDescription: Immediate medical attention for accidents,\n injuries, or severe illness, available 24/7.");
        emergencydesc.setFont(Font.font("Trebuchet MS", 17));
        emergencydesc.setStyle(" -fx-text-fill: grey;");
        VBox vb5 = new VBox(10, emergency, emergencydesc);

        Label surgery = new Label("Surgery");
        surgery.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 35));
        surgery.setStyle(" -fx-text-fill: black;");
        Label surgerydesc = new Label("Price Range: Varies widely\nDescription: Various surgical procedures, from routine to complex,\n performed by experienced veterinarians.");
        surgerydesc.setFont(Font.font("Trebuchet MS", 17));
        surgerydesc.setStyle(" -fx-text-fill: grey;");
        VBox vb6 = new VBox(10, surgery, surgerydesc);

        VBox facilitiesHBox1 = new VBox(30, vb1, vb2);
        facilitiesHBox1.setStyle("-fx-alignment: center;");
        VBox facilitiesHBox2 = new VBox(30, vb3, vb4);
        facilitiesHBox2.setStyle("-fx-alignment: center;");
        VBox facilitiesHBox3 = new VBox(30, vb5, vb6);
        facilitiesHBox3.setStyle("-fx-alignment: center;");
        HBox merge = new HBox(200, facilitiesHBox1, facilitiesHBox2, facilitiesHBox3);
        merge.setStyle("-fx-alignment: center;");

        Button lastButton = new Button("Get our services by check out to our store or book an appointment ");
        lastButton.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 33));
        lastButton.setStyle("-fx-background-color: lightcyan; -fx-text-fill: black;");
        lastButton.setPrefSize(1900, 50);
        lastButton.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> lastButton.setStyle("-fx-text-fill: yellow;"));
        lastButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> lastButton.setStyle(" -fx-text-fill: black;"));
        lastButton.setOnAction(event -> showInfoBox());
        lastButton.setOnAction(event -> showForm());
        
        

        VBox vBo = new VBox(p4, iv5, h1, merge, lastButton);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vBo);
        scrollPane.setPrefSize(1950, 980);
        VBox vb = new VBox(scrollPane);

        return vb;
    }

    private void showInfoBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getDialogPane().setPrefSize(700, 200);
        alert.setTitle("Appointment booked");
        alert.setHeaderText(null);
        alert.setContentText("Your appointment has been booked.\n You can visit our store for further queries.");
        alert.showAndWait();
    }

    private void showForm() {
        Stage formStage = new Stage();
        formStage.setTitle("Book Appointment");
    
        Label nameLabel = new Label("Enter Name:");
        nameLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        nameLabel.setStyle("-fx-text-fill: black;");
        TextField nameField = new TextField();
        nameField.setPrefWidth(300); // Adjust width
    
        Label phoneLabel = new Label("Enter Phone No.:");
        phoneLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        phoneLabel.setStyle("-fx-text-fill: black;");
        TextField phoneField = new TextField();
        phoneField.setPrefWidth(300); // Adjust width
    
        Label emailLabel = new Label("Enter Email:");
        emailLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        emailLabel.setStyle("-fx-text-fill: black;");
        TextField emailField = new TextField();
        emailField.setPrefWidth(300); // Adjust width
    
        Label ageLabel = new Label("Enter Age:");
        ageLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        ageLabel.setStyle("-fx-text-fill: black;");
        TextField ageField = new TextField();
        ageField.setPrefWidth(300); // Adjust width
    
        Label sexLabel = new Label("Select Gender:");
        sexLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        sexLabel.setStyle("-fx-text-fill: black;");
    
        ToggleGroup sexGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        maleRadio.setToggleGroup(sexGroup);
        femaleRadio.setToggleGroup(sexGroup);
    
        HBox sexBox = new HBox(10, maleRadio, femaleRadio);
        sexBox.setAlignment(Pos.CENTER);
    
        Label descriptionLabel = new Label("Description:");
        descriptionLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        descriptionLabel.setStyle("-fx-text-fill: black;");
        TextArea descriptionField = new TextArea();
        descriptionField.setPrefWidth(300); // Adjust width
        descriptionField.setPrefHeight(100); // Adjust height
    
        Label servicesLabel = new Label("Select Services:");
        servicesLabel.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 17));
        servicesLabel.setStyle("-fx-text-fill: black;");
    
        checkBox1 = new CheckBox("General Veterinary Check-Up");
        checkBox1.setTooltip(new Tooltip("Price Range: Rs500 - 1000\nDescription: A routine examination to assess your dog’s overall health, including physical examination and basic diagnostics."));
        checkBox2 = new CheckBox("Vaccination");
        checkBox2.setTooltip(new Tooltip("Price Range: Rs200 - 500 per vaccine\nDescription: Essential vaccinations like rabies, distemper, parvovirus, and others to prevent common diseases."));
        checkBox3 = new CheckBox("Spaying/Neutering");
        checkBox3.setTooltip(new Tooltip("Price Range: Rs2000 - 5000\nDescription: Surgical procedures to sterilize dogs, preventing unwanted breeding and certain health issues."));
        checkBox4 = new CheckBox("Dental Cleaning");
        checkBox4.setTooltip(new Tooltip("Price Range: Rs1000 - 3000\nDescription: Professional cleaning to prevent dental disease, including scaling and polishing of teeth."));
        checkBox5 = new CheckBox("Emergency Care");
        checkBox5.setTooltip(new Tooltip("Price Range: Rs1000 - 2000+\nDescription: Immediate medical attention for accidents, injuries, or severe illness, available 24/7."));
        checkBox6 = new CheckBox("Surgery");
        checkBox6.setTooltip(new Tooltip("Price Range: Varies widely\nDescription: Various surgical procedures, from routine to complex, performed by experienced veterinarians."));
    
        // Add event listeners to update the total amount when a checkbox is selected or deselected
        checkBox1.setOnAction(e -> updateTotalAmount());
        checkBox2.setOnAction(e -> updateTotalAmount());
        checkBox3.setOnAction(e -> updateTotalAmount());
        checkBox4.setOnAction(e -> updateTotalAmount());
        checkBox5.setOnAction(e -> updateTotalAmount());
        checkBox6.setOnAction(e -> updateTotalAmount());
    
        VBox servicesBox = new VBox(10, checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6);
        servicesBox.setAlignment(Pos.CENTER);
    
        totalAmountLabel = new Label("Total Amount: Rs0.00");
        totalAmountLabel.setFont(Font.font("Trebuchet MS", FontWeight.BOLD, 18));
        totalAmountLabel.setStyle("-fx-text-fill: black;");
    
        Button submitButton = new Button("Submit");
        submitButton.setFont(Font.font("Trebuchet MS", FontWeight.MEDIUM, 30));
        submitButton.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String age = ageField.getText();
            RadioButton selectedSex = (RadioButton) sexGroup.getSelectedToggle();
            String sex = (selectedSex != null) ? selectedSex.getText() : "";
            String description = descriptionField.getText();
    
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || age.isEmpty() || sex.isEmpty() || description.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Form Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill out all fields.");
                alert.showAndWait();
            } else {
                saveAppointment(name, phone, email, age, sex, description, getSelectedServices());
                formStage.close();
                showInfoBox();
            }
        });
    
        // Arrange all fields in a centered layout
        VBox formLayout = new VBox(10, nameLabel, nameField, phoneLabel, phoneField, emailLabel, emailField, ageLabel, ageField, sexLabel, sexBox, descriptionLabel, descriptionField, servicesLabel, servicesBox, totalAmountLabel, submitButton);
        formLayout.setPadding(new Insets(20, 250, 20, 250));
        formLayout.setAlignment(Pos.CENTER);
    
        // Set a background image for the form
        BackgroundImage backgroundImage = new BackgroundImage(new Image("https://i.pinimg.com/736x/95/a6/cd/95a6cd65d12427238d565a4b640fa8ce.jpg", 1000, 1000, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        formLayout.setBackground(new Background(backgroundImage));
    
        // Set the scene with the form layout directly
        Scene formScene = new Scene(formLayout, 1000, 1000);
        formStage.setScene(formScene);
        formStage.show();
    }
    

    private void saveAppointment(String name, String phone, String email, String age, String sex, String description, String services) {
        Map<String, Object> appointmentData = new HashMap<>();
        appointmentData.put("name", name);
        appointmentData.put("phone", phone);
        appointmentData.put("email", email);
        appointmentData.put("age", age);
        appointmentData.put("sex", sex);
        appointmentData.put("description", description);
        appointmentData.put("services", services);

        ApiFuture<DocumentReference> future = firestore.collection("health-appointments").add(appointmentData);

        try {
            // Wait for the write to complete
            future.get();
            System.out.println("Appointment successfully saved!");
        } catch (Exception e) {
            System.err.println("Error saving appointment: " + e.getMessage());
        }
    }

    private String getSelectedServices() {
        StringBuilder services = new StringBuilder();
        if (checkBox1.isSelected()) services.append("General Veterinary Check-Up, ");
        if (checkBox2.isSelected()) services.append("Vaccination, ");
        if (checkBox3.isSelected()) services.append("Spaying/Neutering, ");
        if (checkBox4.isSelected()) services.append("Dental Cleaning, ");
        if (checkBox5.isSelected()) services.append("Emergency Care, ");
        if (checkBox6.isSelected()) services.append("Surgery, ");
        if (services.length() > 0) {
            services.setLength(services.length() - 2); // Remove trailing comma and space
        }
        return services.toString();
    }

    private void updateTotalAmount() {
        double totalAmount = 0;

        if (checkBox1.isSelected()) totalAmount += 500; // Assuming minimum price for the sake of this example
        if (checkBox2.isSelected()) totalAmount += 200; // Assuming minimum price for the sake of this example
        if (checkBox3.isSelected()) totalAmount += 2000; // Assuming minimum price for the sake of this example
        if (checkBox4.isSelected()) totalAmount += 100; // Assuming minimum price for the sake of this example
        if (checkBox5.isSelected()) totalAmount += 1000; // Assuming minimum price for the sake of this example
        if (checkBox6.isSelected()) totalAmount += 1000; // Assuming minimum price for the sake of this example

        totalAmountLabel.setText(String.format("Total Amount: Rs%.2f", totalAmount));
    }
}
