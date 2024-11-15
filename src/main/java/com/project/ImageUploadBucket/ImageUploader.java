package com.project.ImageUploadBucket;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.processing.SupportedOptions;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


public class ImageUploader {
    private static final String BUCKET_NAME = "javafx-thedoghub.appspot.com";
    private static final String CREDENTIALS_PATH = "E:\\core2web\\java_project\\MAVEN_PROJECTS\\thedoghub\\src\\main\\resources\\javafx-thedoghub-firebase.json";
   // private static final Logger logger = Logger.getLogger(ImageUploader.class.getName());


    public static String uploadImage(String filePath,  String fileName) {
         try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(CREDENTIALS_PATH));
            Storage storage = StorageOptions.newBuilder()
                    .setCredentials(credentials)
                    .build()
                    .getService();
            
            Path path = Paths.get(filePath) ;  
            byte[] bytes=Files.readAllBytes(path);     

            BlobId blobId = BlobId.of(BUCKET_NAME, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg")
            .setAcl(Arrays.asList(Acl.of(Acl.User.ofAllUsers(),Acl.Role.READER)))
            .build();

            storage.create(blobInfo, bytes);

            return "https://storage.googleapis.com/"+BUCKET_NAME+"/"+fileName;
        } catch (IOException e) {
         // logger.log(Level.SEVERE, "Failed to upload image to Google Cloud Storage", e);
         System.out.println("Image not upload");
         System.out.println(e);
            return null;
        }
    }


    
}


