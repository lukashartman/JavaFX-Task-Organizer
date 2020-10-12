import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    //Create global lists of Assignments and Courses
    public static ArrayList<Assignment> assignmentsList = new ArrayList<>();
    public static ArrayList<Course> coursesList = new ArrayList<>();

    //Instance Variables
    private Stage window;
    private Scene scene1;
    private HBox mainPane;

    //Method to launch application
    public static void main(String[] args){
        launch(args);
    }

        //Method to display application
        public void start (Stage primaryStage){

        //Try to read previously saved assignments and courses
        try {
            FileInputStream fis = new FileInputStream("assignments.ser");
            ObjectInputStream ois = new ObjectInputStream( fis );
            assignmentsList = (ArrayList<Assignment>) ois.readObject();
            ois.close( );
            fis.close();

            FileInputStream fis2 = new FileInputStream("courses.ser");
            ObjectInputStream ois2 = new ObjectInputStream( fis2 );
            coursesList = (ArrayList<Course>) ois2.readObject();
            ois2.close( );
            fis2.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        //Setup stage, scene, and window
        primaryStage.setResizable(false);
        window = primaryStage;
        mainPane = new MainPane();

        scene1 = new Scene(mainPane, 950, 400);
        scene1.getStylesheets().add("buttonStyles.css");

        window.setScene(scene1);
        window.setTitle("Your Agenda");
        window.show();
    }


    //Method to run on application stop
    public void stop(){

        //Save assignments and courses to files
        try {
            FileOutputStream bytesToDisk = new FileOutputStream("assignments.ser");
            ObjectOutputStream objectToBytes = new ObjectOutputStream( bytesToDisk );
            objectToBytes.writeObject(assignmentsList);
            objectToBytes.close();

            FileOutputStream bytesToDisk2 = new FileOutputStream("courses.ser");
            ObjectOutputStream objectToBytes2 = new ObjectOutputStream( bytesToDisk2 );
            objectToBytes2.writeObject(coursesList);
            objectToBytes2.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
