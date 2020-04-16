import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class EditCoursesPane extends HBox {

    private Label courseTitleLabel, courseProfessorLabel, courseLocationLabel, allCoursesLabel;
    private TextField courseTitleField, courseProfessorField, courseLocationField;
    private Button saveButton, removeCourseButton;
    private VBox leftPane, leftHalf, rightHalf, coursesPane;
    private MainPane mainPane;
    private Line dividerLine;
    private static ArrayList<String> coursesToRemove = new ArrayList<>();

    public EditCoursesPane(LeftPane leftPane, MainPane mainPane) {

        this.leftPane = leftPane;
        this.mainPane = mainPane;

        leftHalf = new VBox();
        leftHalf.setPadding(new Insets(15,5,5,15));
        leftHalf.setPrefWidth(350);
        leftHalf.setAlignment(Pos.TOP_CENTER);
        leftHalf.setSpacing(5);

        rightHalf = new VBox();
        rightHalf.setPadding(new Insets(5,5,5,15));
        rightHalf.setPrefWidth(350);

        coursesPane = new VBox();
        rightHalf.setSpacing(10);

        allCoursesLabel = new Label("All Courses");
        allCoursesLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        allCoursesLabel.setTextFill(Color.BLACK);

        courseTitleLabel = new Label("Title");
        courseTitleLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        courseTitleLabel.setTextFill(Color.BLACK);

        courseProfessorLabel = new Label("Professor");
        courseProfessorLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        courseProfessorLabel.setTextFill(Color.BLACK);

        courseLocationLabel = new Label("Location");
        courseLocationLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        courseLocationLabel.setTextFill(Color.BLACK);

        courseTitleField = new TextField();
        courseProfessorField = new TextField();
        courseLocationField = new TextField();

        saveButton = new Button("Save");
        saveButton.getStyleClass().add("saveButton");

        removeCourseButton = new Button("Remove Selected");
        removeCourseButton.getStyleClass().add("removeButton");
        removeCourseButton.setAlignment(Pos.BOTTOM_CENTER);



        dividerLine = new Line(350, 0, 350, 400);

        updateCoursesList();

        this.setAlignment(Pos.CENTER);
        leftHalf.getChildren().addAll(courseTitleLabel,courseTitleField, courseProfessorLabel, courseProfessorField, courseLocationLabel, courseLocationField, saveButton);
        rightHalf.getChildren().addAll(allCoursesLabel, coursesPane, removeCourseButton);
        this.getChildren().addAll(leftHalf, dividerLine, rightHalf);

        saveButton.setOnAction(new SaveButtonHandler());
        removeCourseButton.setOnAction(new RemoveButtonHandler());
    }

    private class SaveButtonHandler implements EventHandler<ActionEvent> {

        //Override the abstact method handle()
        public void handle(ActionEvent event) {
            if (courseTitleField.getText()!=null && courseProfessorField.getText()!=null && courseLocationField.getText()!=null) {
                Course tempCourse = new Course(courseTitleField.getText(), courseProfessorField.getText(), courseLocationField.getText());
                Main.coursesList.add(tempCourse);
                System.out.println(Main.coursesList.size());
                AddAssignmentPane.updateCourseSelectcb();
                courseTitleField.clear();
                courseProfessorField.clear();
                courseLocationField.clear();
                updateCoursesList();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please fill all fields and try again.");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            }
        }
    }

    private void updateCoursesList(){

        coursesPane.getChildren().removeIf(CheckBox.class::isInstance);

        for (int i = 0; i < Main.coursesList.size(); i++){
            CheckBox tempCheck = new CheckBox(Main.coursesList.get(i).getCourseTitle());
            tempCheck.setOnAction(new SelectionHandler());
            coursesPane.getChildren().add(tempCheck);
        }
    }

    private class RemoveButtonHandler implements EventHandler<ActionEvent> {

        //Override the abstact method handle()
        public void handle(ActionEvent event) {
            for (int i = 0; i < coursesToRemove.size(); i++) {
                for (int j = 0; j < Main.assignmentsList.size() ; j++)
                    if (coursesToRemove.get(i).equalsIgnoreCase(Main.assignmentsList.get(j).getCourse().getCourseTitle())) {
                        System.out.println("Removed Assignment");
                        Main.assignmentsList.remove(j);
                    }
            }

            for (int y = 0; y < coursesToRemove.size(); y++){
                for (int x = 0; x < Main.coursesList.size(); x++){
                    if (coursesToRemove.get(y).equalsIgnoreCase(Main.coursesList.get(x).getCourseTitle())){
                        Main.coursesList.remove(x);
                    }
                }
            }
            AddAssignmentPane.updateCourseSelectcb();
            updateCoursesList();
            TodayPane.updateTodayPane();
            WeeklyPane.updateWeeklyPane();
            AllAssignmentsPane.updateAllAssignmentsPane();
        }
    }

    private class SelectionHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            CheckBox activeBox = (CheckBox) event.getSource(); //Save the source of the event to CheckBox object
            System.out.println(activeBox.toString());
            if (activeBox.isSelected())
                coursesToRemove.add(activeBox.getText());
        }

    }
}
