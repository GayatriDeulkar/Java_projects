package com.project.SalonPageUI;

import java.util.HashMap;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.project.MainApp;
import com.project.fireConfig.dataService;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SalonPage {
    private MainApp mainApp;
    private Firestore firestore;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private Label totalAmountLabel;

    public SalonPage(MainApp mainApp) {
        this.mainApp = mainApp;
        this.firestore = dataService.db;
    }
    
    public VBox getSalonPage(){
       
      
        Button shopNow = new Button("Shop Now");
        shopNow.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,33));
        shopNow.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");
        shopNow.setPrefSize(350, 70);
        shopNow.setLayoutX(1150);
        shopNow.setLayoutY(290);
        shopNow.addEventHandler(MouseEvent.MOUSE_PRESSED,event ->{
            shopNow.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:black");
        });    
        shopNow.addEventHandler(MouseEvent.MOUSE_RELEASED, event ->{
            shopNow.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:white");
        });
        shopNow.setOnAction(e -> mainApp.showFashionPage());

        Image image1 = new Image("com\\project\\assets\\salonimage\\grooming.png",1860,0,true,false);
        ImageView imageView1 = new ImageView(image1);
        Pane p1 = new Pane(imageView1,shopNow);
        

        Button shopNow1 = new Button("Get some grooming essentials");
        shopNow1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,33));
        shopNow1.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        shopNow1.setPrefSize(530, 30);
        shopNow1.setLayoutX(680);
        shopNow1.setLayoutY(210);
        shopNow1.addEventHandler(MouseEvent.MOUSE_PRESSED,event ->{
            shopNow1.setStyle("-fx-background-color: black;-fx-text-fill:#ef6c00");
        });    
        shopNow1.addEventHandler(MouseEvent.MOUSE_RELEASED, event ->{
            shopNow1.setStyle("-fx-background-color: black;-fx-text-fill:white");
        });
        shopNow1.setOnAction(e -> mainApp.showFashionPage());
    
        Image image2 = new Image("com\\project\\assets\\salonimage\\solu.jpeg",1860,0,true,false);
        ImageView imageView2 = new ImageView(image2);
        Pane p2 = new Pane(imageView2,shopNow1);

        
        
        Image image3 = new Image("com\\project\\assets\\salonimage\\label.png",1860,0,true,true);
        ImageView imageView3 = new ImageView(image3);
       
        Image image4 = new Image("com\\project\\assets\\salonimage\\salon.png",1860,0,true,false);
        ImageView imageView4 = new ImageView(image4);

        
       
        

        Button BookApp = new Button("Book Appointment");
        BookApp.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,33));
        BookApp.setStyle("-fx-background-color: #ef6c00; -fx-text-fill: white;");//#55CEFF
        BookApp.setPrefSize(350, 50);
        BookApp.setLayoutX(350);
        BookApp.setLayoutY(250);
        BookApp.addEventHandler(MouseEvent.MOUSE_PRESSED,event ->{
            BookApp.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:black");
        });    
        BookApp.addEventHandler(MouseEvent.MOUSE_RELEASED, event ->{
           BookApp.setStyle("-fx-background-color: #ef6c00;-fx-text-fill:white");
        });
        BookApp.setOnAction(event -> showInfoBox());
        BookApp.setOnAction(event -> showForm());

        Label label2 = new Label("Where Every Dog Gets the Royal Treatment!!!...");
        label2.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,45));
        label2.setStyle("-fx-text-fill:black;");
        label2.setLayoutX(100);
        label2.setLayoutY(100); 
        

        Pane p3 = new Pane(imageView4,BookApp,label2);
        Label label1 = new Label("                                         Pamper Your Pup, Pawsitively Purrfect Pampering....!!                                ");
        label1.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,40));
        label1.setStyle("-fx-text-fill:black;");
       
        
       
        

        Label label3 = new Label("Grooming Services:");
        label3.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label3.setStyle("-fx-text-fill:black;");
        Label deslabel = new Label(" Bathing: Using dog-friendly shampoos and conditioners.\n Brushing: Removing tangles, mats, and loose fur.\nHaircuts: Stylish cuts tailored to the breed and owner's preference.\nDrying: Gentle blow-drying to avoid stress.\n Price Range: 2000-3000\n" );   
        deslabel.setStyle(" -fx-text-fill: grey;");             
        deslabel.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17));                
        VBox vb3 = new VBox(label3,deslabel);

        Label label6 = new Label("Ear and Eye Care:");
        label6.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label6.setStyle("-fx-text-fill:black;");
        Label deslabel6 = new Label(" Ear Cleaning: Removing dirt and wax buildup.\n Eye Cleaning: Removing tear stains and debris.\n Price Range: 2000-3000\n" );                              
        deslabel6.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17)); 
        deslabel6.setStyle(" -fx-text-fill: grey;");               
        VBox vb6 = new VBox(label6,deslabel6);

        VBox vblabel1 = new VBox(0,vb3,vb6);
        
        Label label4 = new Label("Spa Treatments:");
        label4.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label4.setStyle("-fx-text-fill:black;");
        Label deslabel4 = new Label(" Massage: Relaxing muscle massages for stress relief.\n Aromatherapy: Using essential oils for a calming experience.\n Facials: Gentle cleansing and moisturizing of the face.\n Price Range: 3000-3000\n" );                 
        deslabel4.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17)); 
        deslabel4.setStyle(" -fx-text-fill: grey;");
        VBox vb4 = new VBox(label4,deslabel4);

        Label label7 = new Label("Specialized Grooming Services:");
        label7.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label7.setStyle("-fx-text-fill:black;");
        Label deslabel7 = new Label(" Breed-Specific Styling: Customized grooming based on breed standards.\n De-shedding Treatments: Reducing excess shedding with specialized tools and products.\n Flea and Tick Treatments: Removing and preventing parasites.\n Price Range: 2000-3000\n");                                
        deslabel7.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17)); 
        deslabel7.setStyle(" -fx-text-fill: grey;");
        VBox vb7 = new VBox(label7,deslabel7);
        VBox vblabel2 = new VBox(30,vb4,vb7);

        Label label5 = new Label("Nail Care:");
        label5.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label5.setStyle("-fx-text-fill:black;");
        Label deslabel5 = new Label(" Nail Trimming: Safely cutting nails to the appropriate length.\n Nail Grinding: Smoothing and rounding nails for comfort and safety\n Price Range: 2000-3000\n");                                
        deslabel5.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17)); 
        deslabel5.setStyle(" -fx-text-fill: grey;");
        VBox vb5 = new VBox(label5,deslabel5);


        Label label8 = new Label("Additional Services:");
        label8.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,35));
        label8.setStyle("-fx-text-fill:black;");
        Label deslabel8 = new Label("Anal Gland Expression: Ensuring the glands are empty and healthy.\nPrice: 2000\nPaw Pad Treatments: Moisturizing and protecting the paw pads.\nCreative Grooming: Adding temporary colors or designs to the fur."
                        );
        deslabel8.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,17));  
        deslabel8.setStyle(" -fx-text-fill: grey;");              
        VBox vb8 = new VBox(label8,deslabel8);    
        VBox vblabel3 = new VBox(30,vb5,vb8);
        
        HBox hb2 = new HBox(30,vblabel1,vblabel2,vblabel3); 

        Button LastButton = new Button("Get our service by check out to our store or book a appointment");
        LastButton.setFont(Font.font("Trebuchet MS",FontWeight.BOLD,33));
        LastButton.setStyle("-fx-background-color: #55CEFF; -fx-text-fill: white;");
        LastButton.setPrefSize(1860, 50);
       
        LastButton.addEventHandler(MouseEvent.MOUSE_PRESSED,event ->{
            LastButton.setStyle("-fx-background-color: #55CEFF;-fx-text-fill:black");
        });    
       LastButton.addEventHandler(MouseEvent.MOUSE_RELEASED, event ->{
           LastButton.setStyle("-fx-background-color:#55CEFF;-fx-text-fill:white");
        });
        LastButton.setOnAction(event -> showInfoBox());
        LastButton.setOnAction(event -> showForm());

        
       
        VBox vb = new VBox(15,p1,p2,label1,p3,imageView3,hb2,LastButton); 
        vb.setPadding(new Insets(20));   
        
       
        ScrollPane scrollPane = new ScrollPane(vb);
      
        scrollPane.setPrefSize(1860, 980);
       // HBox hb3 = new HBox();
       VBox vbox=new VBox(scrollPane);
       return vbox;

        
        //Group gr = new  Group(scrollPane,hb3);
        // Scene sc = new Scene(scrollPane);

        //  primaryStage.setScene(sc);
        //  primaryStage.show();
    }
    private static void showInfoBox() {
        Alert alert = new Alert(AlertType.INFORMATION);
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
    
        checkBox1 = new CheckBox("Grooming Services:");
        checkBox1.setTooltip(new Tooltip("Bathing: Using dog-friendly shampoos and conditioners.\\n" + //
                        " Brushing: Removing tangles, mats, and loose fur.\\n" + //
                        "Haircuts: Stylish cuts tailored to the breed and owner's preference.\\n" + //
                        "Drying: Gentle blow-drying to avoid stress.\\n" + //
                        " Price Range: 2000-3000\\n" + //
                        ""));
        checkBox2 = new CheckBox("Ear and Eye Care:");
        checkBox2.setTooltip(new Tooltip(" Ear Cleaning: Removing dirt and wax buildup.\\n" + //
                        " Eye Cleaning: Removing tear stains and debris.\\n" + //
                        " Price Range: 2000-3000\\n" + //
                        ""));
        checkBox3 = new CheckBox("Spa Treatments:");
        checkBox3.setTooltip(new Tooltip("Massage: Relaxing muscle massages for stress relief.\\n" + //
                        " Aromatherapy: Using essential oils for a calming experience.\\n" + //
                        " Facials: Gentle cleansing and moisturizing of the face.\\n" + //
                        " Price Range: 3000-3000\\n" + //
                        ""));
        checkBox4 = new CheckBox("Specialized Grooming Services:");
        checkBox4.setTooltip(new Tooltip(" Breed-Specific Styling: Customized grooming based on breed standards.\\n" + //
                        " De-shedding Treatments: Reducing excess shedding with specialized tools and products.\\n" + //
                        " Flea and Tick Treatments: Removing and preventing parasites.\\n" + //
                        " Price Range: 2000-3000\\n" + //
                        ""));
        checkBox5 = new CheckBox("Nail Care:");
        checkBox5.setTooltip(new Tooltip(" Nail Trimming: Safely cutting nails to the appropriate length.\\n" + //
                        " Nail Grinding: Smoothing and rounding nails for comfort and safety\\n" + //
                        " Price Range: 2000-3000\\n" + //
                        ""));
        checkBox6 = new CheckBox("Additional Services:");
        checkBox6.setTooltip(new Tooltip("Anal Gland Expression: Ensuring the glands are empty and healthy.\\n" + //
                        "Price: 2000\\n" + //
                        "Paw Pad Treatments: Moisturizing and protecting the paw pads.\\n" + //
                        "Creative Grooming: Adding temporary colors or designs to the fur."));
    
        // Add event listeners to update the total amount when a checkbox is selected or deselected
        checkBox1.setOnAction(e -> updateTotalAmount());
        checkBox2.setOnAction(e -> updateTotalAmount());
        checkBox3.setOnAction(e -> updateTotalAmount());
        checkBox4.setOnAction(e -> updateTotalAmount());
        checkBox5.setOnAction(e -> updateTotalAmount());
        checkBox6.setOnAction(e -> updateTotalAmount());
    
        VBox servicesBox = new VBox(10, checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6);
        servicesBox.setAlignment(Pos.CENTER);
    
        totalAmountLabel = new Label("Total Amount: $0.00");
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
        BackgroundImage backgroundImage = new BackgroundImage(new Image("https://img.freepik.com/premium-vector/collection-cute-dog-with-spa-salon-theme-flat-vector-style_77984-1466.jpg", 1000, 1000, false, true),
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
        appointmentData.put("gender", sex);
        appointmentData.put("description", description);
        appointmentData.put("services", services);
        System.out.println(firestore);

        ApiFuture<DocumentReference> future = firestore.collection("salon-appointments").add(appointmentData);

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
        if (checkBox1.isSelected()) services.append("Grooming service, ");
        if (checkBox2.isSelected()) services.append("Ear and Eye Care:, ");
        if (checkBox3.isSelected()) services.append("Spa Treatments:, ");
        if (checkBox4.isSelected()) services.append("Specialized Grooming Services:, ");
        if (checkBox5.isSelected()) services.append("Nail Care:, ");
        if (checkBox6.isSelected()) services.append("Additional Services:, ");
        if (services.length() > 0) {
            services.setLength(services.length() - 2); // Remove trailing comma and space
        }
        return services.toString();
    }
    private void updateTotalAmount() {
        double totalAmount = 0;

        if (checkBox1.isSelected()) totalAmount += 1500; // Assuming minimum price for the sake of this example
        if (checkBox2.isSelected()) totalAmount += 2500; // Assuming minimum price for the sake of this example
        if (checkBox3.isSelected()) totalAmount += 3000; // Assuming minimum price for the sake of this example
        if (checkBox4.isSelected()) totalAmount += 3000; // Assuming minimum price for the sake of this example
        if (checkBox5.isSelected()) totalAmount += 1500; // Assuming minimum price for the sake of this example
        if (checkBox6.isSelected()) totalAmount += 2000; // Assuming minimum price for the sake of this example

        totalAmountLabel.setText(String.format("Total Amount: $%.2f", totalAmount));
    }
}
