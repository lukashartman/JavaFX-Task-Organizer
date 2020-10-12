import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;

import java.time.LocalDate;

public class TodayPane extends HBox {

    //Instance variables
    private Line dividerLine;
    public static VBox todayVbox, tomorrowVbox;
    private Label todayLabel, tomorrowLabel;

    public TodayPane() {

        //Setup all labels with correct font
        todayLabel = new Label("Due Today");
        todayLabel.getStyleClass().add("todayViewHeaderLabels");

        tomorrowLabel = new Label("Due Tomorrow");
        tomorrowLabel.getStyleClass().add("todayViewHeaderLabels");

        //Create and setup today (left of pane)
        todayVbox = new VBox(todayLabel);
        todayVbox.setPadding(new Insets(5, 5, 5, 15));
        todayVbox.setPrefWidth(350);

        //Create and setup tomorrow (right of pane)
        tomorrowVbox = new VBox(tomorrowLabel);
        tomorrowVbox.setPadding(new Insets(5, 5, 5, 15));
        tomorrowVbox.setPrefWidth(350);

        //Call method to add most recent list of assignments to pane
        updateTodayPane();

        //Setup of a line to divide left from right halves
        dividerLine = new Line(350, 0, 350, 400);

        //Add the left and right half vboxes and divider line to entire pane
        this.getChildren().addAll(todayVbox, dividerLine, tomorrowVbox);

    }

    //Method to update the assignments in this pane
    public static void updateTodayPane() {

        //Remove all checkboxes from VBox
        todayVbox.getChildren().removeIf(CheckBox.class::isInstance);
        tomorrowVbox.getChildren().removeIf(CheckBox.class::isInstance);

        //Cycle through assignments list and create new checkboxes for all assignments
        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            if (LocalDate.now().equals(Main.assignmentsList.get(i).getDueDate())) {
                todayVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            } else if (LocalDate.now().plusDays(1).equals(Main.assignmentsList.get(i).getDueDate())) {
                tomorrowVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            }
        }
    }

}
