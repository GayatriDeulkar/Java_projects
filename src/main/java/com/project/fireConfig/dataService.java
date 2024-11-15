package com.project.fireConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.project.DogPageUI.DogsUIPage;
import com.project.FashionPageUI.FashionPageUI;
import com.project.FoodPageUI.FoodPageUI;
import com.project.MedicinePagUI.MedicinePageUI;
import com.project.OrderPageUI.OrderPageUI;



public class dataService{

     public static Firestore db ;

     static {
        try {
              initializeFirebase();
        }catch(IOException e){
            e.printStackTrace();
        }
     }

     private static void initializeFirebase() throws IOException{
        FileInputStream serviceAccount = new FileInputStream("E:\\core2web\\java_project\\MAVEN_PROJECTS\\thedoghub\\src\\main\\resources\\javafx-thedoghub-firebase.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
        DogsUIPage.firestore = db;
            FoodPageUI.firestore = db;
            MedicinePageUI.firestore = db;
            FashionPageUI.firestore = db;
            OrderPageUI.firestore = db;
    }

    public void addData(String collection, String document,Map<String,Object> data) throws ExecutionException,InterruptedException{
        DocumentReference docRef = db.collection(collection).document(document);
        ApiFuture<WriteResult> result = docRef.set(data);
        result.get();
    }

    public DocumentSnapshot getData(String collection,String document)throws ExecutionException,InterruptedException{
        try{
            DocumentReference docRef = db.collection(collection).document(document);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            return future.get();

        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }

    }

        public boolean authenticateUser(String username, String password) throws ExecutionException,InterruptedException{
            DocumentSnapshot document = db.collection("users").document(username).get().get();
             if(document.exists()){
                String storedpassword = document.getString("password");
                return password.equals(storedpassword);
             }
            return false; 
        }

        public boolean isAdmin(String username) throws ExecutionException,InterruptedException{
            DocumentSnapshot document = db.collection("users").document(username).get().get();
             if(document.exists()){
                String role = document.getString("role");
                System.out.println(role);
                return"admin".equals(role);
             }
            return false; 
        }

        public void deleteProject(String collectionName, String leaderName)
                throws ExecutionException, InterruptedException {

            System.out.println(leaderName);
            ApiFuture<WriteResult> writeResult = db.collection(collectionName).document(leaderName).delete();
            writeResult.get();
        }
       
        public List<Map<String, Object>> getDataInDescendingOrder(String collectionName,
           String orderByField) throws ExecutionException, InterruptedException {
           List<Map<String, Object>> documentsList = new ArrayList<>();
            
           CollectionReference collection = db.collection(collectionName);
           Query query = collection.orderBy(orderByField, Query.Direction.DESCENDING);

           // Execute the query
           ApiFuture<QuerySnapshot> querySnapshot = query.get();
           for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
             documentsList.add(document.getData());
            }
            return documentsList;
        }
        public void updateData(String collectionName, String documentId, Map<String,
        Object> updatedData)throws ExecutionException, InterruptedException {
        // Reference to the Firestore collection
        CollectionReference collection = db.collection(collectionName);
        // Reference to the document to update
        DocumentReference docRef = collection.document(documentId);
        // Update the document
        ApiFuture<WriteResult> future = docRef.set(updatedData, SetOptions.merge());

        // Wait for the update to complete
        future.get();

        }

        
    
}
