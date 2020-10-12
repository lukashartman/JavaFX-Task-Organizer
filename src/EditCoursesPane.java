import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class EditCoursesPane extends HBox {

    //Instance variables
    private Label courseTitleLabel, courseProfessorLabel, courseLocationLabel, allCoursesLabel;
    private TextField courseTitleField, courseProfessorField, courseLocationField;
    private Button saveButton, removeCourseButton;
    private VBox leftHalf, rightHalf, coursesPane;
    private Line dividerLine;
    private static ArrayList<String> coursesToRemove = new ArrayList<>();

    public EditCoursesPane() {

        //Create and setup left half of pane
        leftHalf = new VBox();
        leftHalf.setPadding(new Insets(15, 5, 5, 15));
        leftHalf.setPrefWidth(350);
        leftHalf.setAlignment(Pos.TOP_CENTER);
        leftHalf.setSpacing(5);

        //Create and setup right half of pane
        rightHalf = new VBox();
        rightHalf.setPadding(new Insets(5, 5, 5, 15));
        rightHalf.setPrefWidth(350);

        //Create and setup pane to hold list of courses
        coursesPane = new VBox();
        rightHalf.setSpacing(10);

        //Setup all labels with correct font
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

        //Setup all input methods for user
        courseTitleField = new TextField();
        courseProfessorField = new TextField();
        courseLocationField = new TextField();

        //Setup save button
        saveButton = new Button("Save");
        saveButton.getStyleClass().add("saveButton");
        saveButton.setOnAction(new SaveButtonHandler());

        //Setup remove course button
        removeCourseButton = new Button("Remove Selected");
        removeCourseButton.getStyleClass().add("removeButton");
        removeCourseButton.setOnAction(new RemoveButtonHandler());

        //Setup of a line to divide left from right halves
        dividerLine = new Line(350, 0, 350, 400);

        //Call method to add most recent list of courses to pane
        updateCoursesList();

        //Add relevent nodes to left and right half vboxes
        leftHalf.getChildren().addAll(courseTitleLabel, courseTitleField, courseProfessorLabel, courseProfessorField, courseLocationLabel, courseLocationField, saveButton);
        rightHalf.getChildren().addAll(allCoursesLabel, coursesPane, removeCourseButton);

        //Add the left and right half vboxes and divider line to entire pane
        this.getChildren().addAll(leftHalf, dividerLine, rightHalf);

    }

    //Method to update the course list display
    private void updateCoursesList() {

        //Remove all current checkboxes from rightHalf pane
        coursesPane.getChildren().removeIf(CheckBox.class::isInstance);

        //Cycle through courses list and create new checkboxes for all courses
        for (int i = 0; i < Main.coursesList.size(); i++) {
            CheckBox tempCheck = new CheckBox(Main.coursesList.get(i).getCourseTitle());
            tempCheck.setOnAction(new SelectionHandler());
            coursesPane.getChildren().add(tempCheck);
        }
    }

    //Create nested class Event Handler for save button action
    private class SaveButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {

            //Ensure all fields have been filled
            if (courseTitleField.getText() != null && courseProfessorField.getText() != null && courseLocationField.getText() != null) {

                //Create temp variable to hold new course and add to courses list
                Course tempCourse = new Course(courseTitleField.getText(), courseProfessorField.getText(), courseLocationField.getText());
                Main.coursesList.add(tempCourse);

                //Clear input fields
                courseTitleField.clear();
                courseProfessorField.clear();
                courseLocationField.clear();

                //Call global method to update items in courseSelection ComboBox
                AddAssignmentPane.updateCourseSelectcb();

                //Call method to add most recent list of courses to pane
                updateCoursesList();

            //Otherwise, display alert to user
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please fill all fields and try again.");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            }
        }
    }

    private class RemoveButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            for (int i = 0; i < coursesToRemove.size(); i++) {
                for (int j = 0; j < Main.assignmentsList.size(); j++)
                    if (coursesToRemove.get(i).equalsIgnoreCase(Main.assignmentsList.get(j).getCourse().getCourseTitle())) {
                        Main.assignmentsList.remove(j);
                    }
            }

            for (int y = 0; y < coursesToRemove.size(); y++) {
                for (int x = 0; x < Main.coursesList.size(); x++) {
                    if (coursesToRemove.get(y).equalsIgnoreCase(Main.coursesList.get(x).getCourseTitle())) {
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

            CheckBox activeBox = (CheckBox) event.getSource();
            if (activeBox.isSelected())
                coursesToRemove.add(activeBox.getText());
        }

    }
}
