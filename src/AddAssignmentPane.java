import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class AddAssignmentPane extends HBox {

    //Instance variables
    private Label assignmentTitleLabel, assignmentCourseLabel, assignmentDueDateLabel, assignmentsForCourseLabel;
    private TextField assingmentTitleField;
    private Button saveButton;
    private static ComboBox<String> courseSelectcb;
    private DatePicker datePicker;
    private VBox leftHalf, rightHalf;
    private Line dividerLine;


    public AddAssignmentPane() {

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

        //Setup all labels with correct font
        assignmentTitleLabel = new Label("Title");
        assignmentTitleLabel.setFont(new Font("Avenir Next Condensed Bold", 20));

        assignmentCourseLabel = new Label("Course");
        assignmentCourseLabel.setFont(new Font("Avenir Next Condensed Bold", 20));

        assignmentDueDateLabel = new Label("Due Date");
        assignmentDueDateLabel.setFont(new Font("Avenir Next Condensed Bold", 20));

        //Label will be dynamically set later
        assignmentsForCourseLabel = new Label("");
        assignmentsForCourseLabel.setFont(new Font("Avenir Next Condensed Bold", 20));

        //Setup all input methods for user
        assingmentTitleField = new TextField();
        datePicker = new DatePicker();
        courseSelectcb = new ComboBox<>();
        courseSelectcb.setPrefWidth(189);
        courseSelectcb.setOnAction(new SelectionHandler());

        //Call method to add most recent list of courses to CB
        updateCourseSelectcb();

        //Setup save button
        saveButton = new Button("Save");
        saveButton.getStyleClass().add("saveButton");
        saveButton.setOnAction(new SaveButtonHandler());

        //Setup of a line to divide left from right halves
        dividerLine = new Line(350, 0, 350, 400);

        //Add relevent nodes to left and right half vboxes
        leftHalf.getChildren().addAll(assignmentTitleLabel, assingmentTitleField, assignmentCourseLabel, courseSelectcb, assignmentDueDateLabel, datePicker, saveButton);
        rightHalf.getChildren().addAll(assignmentsForCourseLabel);

        //Add the left and right half vboxes and divider line to entire pane
        this.getChildren().addAll(leftHalf, dividerLine, rightHalf);
    }

    //Method to update the course selection combobox
    public static void updateCourseSelectcb() {

        //Remove all items from CB
        courseSelectcb.getItems().clear();

        //Cycle through courses list and add all items to CB
        for (int i = 0; i < Main.coursesList.size(); i++) {
            courseSelectcb.getItems().add(Main.coursesList.get(i).getCourseTitle());
        }
    }

    //Create nested class Event Handler for CB selection
    private class SelectionHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {

            //Make sure combobox has a selection
            if (courseSelectcb.getValue() != null) {

                //Remove all current checkboxes from rightHalf pane
                rightHalf.getChildren().removeIf(CheckBox.class::isInstance);

                //Cycle through course list and find selected item from CB
                for (int i = 0; i < Main.coursesList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.coursesList.get(i).getCourseTitle())) {
                        assignmentsForCourseLabel.setText("All " + courseSelectcb.getValue() + " Assignments");
                    }
                }

                //Cycle through assignments list and create new checkboxes for all assignments in selected course
                for (int i = 0; i < Main.assignmentsList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.assignmentsList.get(i).getCourse().getCourseTitle())) {
                        rightHalf.getChildren().add(new CheckBox(Main.assignmentsList.get(i).getAssignmentName() + ": " + Main.assignmentsList.get(i).getDueDate()));
                    }
                }

            //If there is no selection, set label to default text
            } else {
                assignmentsForCourseLabel.setText("Select Course");
            }
        }
    }

    //Create nested class Event Handler for save button action
    private class SaveButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {

            //Ensure all fields have been filled
            if (!courseSelectcb.getSelectionModel().isEmpty() && datePicker.getValue() != null && assingmentTitleField.getText() != null) {

                //Cycle through course list and find which course has been selected
                for (int i = 0; i < Main.coursesList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.coursesList.get(i).getCourseTitle())) {

                        //Create temp variable to hold new assignment and add to assignments list
                        Assignment tempAssignment = new Assignment(datePicker.getValue(), Main.coursesList.get(i), assingmentTitleField.getText());
                        Main.assignmentsList.add(tempAssignment);

                        //Call all methods to update all panes for new assignment
                        WeeklyPane.updateWeeklyPane();
                        TodayPane.updateTodayPane();
                        AllAssignmentsPane.updateAllAssignmentsPane();

                        //Clear input fields
                        courseSelectcb.setValue(null);
                        datePicker.setValue(null);
                        assingmentTitleField.clear();
                        break;
                    }
                }
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
}
