package com.project;

import com.project.Abouus.AboutUsPageUI;
import com.project.AfterLoginProfileUI.AfterLoginProfileUI;
import com.project.DogPageUI.DogsUIPage;
import com.project.FashionPageUI.FashionPageUI;
import com.project.FoodPageUI.FoodPageUI;
import com.project.FormUponGetAppoint.FormUponGetAppo;
import com.project.HealthCarePageUI.HealthCarePage;
import com.project.HelpingHandpageUI.HelpingHand;
import com.project.HomePageUI.HomePageUI;
import com.project.MedicinePagUI.MedicinePageUI;
import com.project.OrderPageUI.OrderPageUI;
import com.project.ProfilePgeUI.CreateAccountController;
import com.project.ProfilePgeUI.LoginController;
import com.project.SalonPageUI.SalonPage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private VBox mainLayout;
    public MainApp mainApp;

    @Override
    public void start(Stage primaryStage) {
        mainLayout = new VBox();
        Navbar navbar = new Navbar(this);
        mainLayout.getChildren().add(navbar.getNavbar());

        // Set the initial content for the Home page
        showHomePage();

        Scene scene = new Scene(mainLayout, 2000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Navbar Example");
        primaryStage.show();
    }

    public void showHomePage() {
        //mainLayout.getChildren().removeIf(node -> node instanceof HomePageUI);
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new HomePageUI(this).getHomePage());
    }

    public void showProfilePage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new LoginController(this).getLoginPage());
    }

    public void showHelpingHandPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new HelpingHand(this).getHelpingHandPage());
    }

    public void showSalonPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new SalonPage(this).getSalonPage());
    }

    public void showHealthCarePage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new HealthCarePage(this).getHealthCarePage());
    }

    public void showDogsPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new DogsUIPage(this).getDogPage());
    }

    public void showFoodPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new FoodPageUI(this).getFoodPage());
    }

    public void showFashionPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new FashionPageUI(this).getFashionPage());
    }
    
    public void showMedicinePage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new MedicinePageUI(this).getMedicinePage());
    }

    // public void showAfterLoginProfileUI() {
    //     if (mainLayout.getChildren().size() > 1) {
    //         mainLayout.getChildren().remove(1); // Remove old content
    //     }
    //     mainLayout.getChildren().add(new CreateAccountController(this).getProfilePage());
    // }

    public void showOrderPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new OrderPageUI(this).getOrderPage());
    }

    public void showFormPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new FormUponGetAppo(this).createDogDetailsForm());
    }

    public void showCreateAccountPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new CreateAccountController(this).getCreateAccountPage());
    }

    public void showLoginPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new LoginController(this).getLoginPage());
    }

    public void showAboutUsPage() {
        if (mainLayout.getChildren().size() > 1) {
            mainLayout.getChildren().remove(1); // Remove old content
        }
        mainLayout.getChildren().add(new AboutUsPageUI(this).getAbouUsPage());
    }
    
    
}