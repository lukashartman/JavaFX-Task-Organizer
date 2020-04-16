import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Assignment> assignmentsList = new ArrayList<>();
    public static ArrayList<Course> coursesList = new ArrayList<>();

    private Stage window;
    private Scene scene1;
    private HBox mainPane;


    public static void main(String[] args){
        launch(args);
    }

        public void start (Stage primaryStage){

        try {
            FileInputStream fis = new FileInputStream("assignments.ser");
            ObjectInputStream ois = new ObjectInputStream( fis );
            assignmentsList = (ArrayList<Assignment>) ois.readObject();
            System.out.println("assignments was read " + assignmentsList.size());
            ois.close( );
            fis.close();

            FileInputStream fis2 = new FileInputStream("courses.ser");
            ObjectInputStream ois2 = new ObjectInputStream( fis2 );
            coursesList = (ArrayList<Course>) ois2.readObject();
            System.out.println("assignments was read " + coursesList.size());
            ois2.close( );
            fis2.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }


        primaryStage.setResizable(false);
        window = primaryStage;
        mainPane = new MainPane();

        scene1 = new Scene(mainPane, 950, 400);
        scene1.getStylesheets().add("buttonStyles.css");


        window.setScene(scene1);
        window.setTitle("Your Agenda");
        window.show();
    }


    public void stop(){
        System.out.println("Stage is closing");
        try {
            FileOutputStream bytesToDisk = new FileOutputStream("assignments.ser");
            ObjectOutputStream objectToBytes = new ObjectOutputStream( bytesToDisk );
            objectToBytes.writeObject(assignmentsList);
            objectToBytes.close();
            System.out.println("assignments was written " + assignmentsList.size());

            FileOutputStream bytesToDisk2 = new FileOutputStream("courses.ser");
            ObjectOutputStream objectToBytes2 = new ObjectOutputStream( bytesToDisk2 );
            objectToBytes2.writeObject(coursesList);
            objectToBytes2.close();
            System.out.println("courses was written " + coursesList.size());
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
