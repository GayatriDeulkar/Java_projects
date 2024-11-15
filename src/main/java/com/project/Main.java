package com.project;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        try{
            // Class.forName("com.project.FirebaseInitiliazation");
            Class.forName("com.project.fireConfig.dataService");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Hello world!");
        Application.launch(MainApp.class,args);

        
        
    }
}