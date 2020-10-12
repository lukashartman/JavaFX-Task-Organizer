
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyPane extends GridPane {

    //Instance variables
    private static VBox[][] rectanglePanes = new VBox[2][3];
    private Button removeButton;
    private static ArrayList<String> stringToRemove = new ArrayList<>();

    public WeeklyPane() {

        //Setup remove button
        removeButton = new Button("Remove Selected");
        removeButton.getStyleClass().add("removeButton");
        removeButton.setOnAction(new RemoveButtonHandler());

        //Create array of vboxes, stylize, and add labels
        int counter = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                VBox tempVbox = new VBox();
                tempVbox.getStyleClass().add("weeklyViewVbox");
                Label dateLabel = new Label(capitalize(LocalDate.now().plusDays(counter).getDayOfWeek().toString()) + ", " +
                        capitalize(LocalDate.now().plusDays(counter).getMonth().toString()) + " " +
                        LocalDate.now().plusDays(counter).getDayOfMonth());
                dateLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
                dateLabel.setTextFill(Color.BLACK);
                rectanglePanes[i][j] = tempVbox;
                rectanglePanes[i][j].setMargin(dateLabel, new Insets(0, 0, 3, 0));
                rectanglePanes[i][j].getChildren().addAll(dateLabel);
                rectanglePanes[i][j].setPadding(new Insets(5, 5, 5, 8));
                this.add(rectanglePanes[i][j], j, i);
                counter++;
            }
        }

        //Call method to add most recent list of assignments to pane
        updateWeeklyPane();

        //Setup pane with spacing and children
        this.setHgap(19);
        this.setVgap(22);
        this.setPadding(new Insets(5, 22, 8, 22));
        this.setHalignment(removeButton, HPos.CENTER);
        this.add(removeButton, 1, 2);

    }

    //Method to update the assignments in this pane
    public static void updateWeeklyPane() {

        //Remove all checkboxes from all VBoxes
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                rectanglePanes[i][j].getChildren().removeIf(CheckBox.class::isInstance);
            }
        }

        //Cycle through assignments list and create new checkboxes for all assignments in respective panes
        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            CheckBox tempCheck = new CheckBox(Main.assignmentsList.get(i).getAssignmentName());
            tempCheck.setOnAction(new SelectionHandler());
            if (LocalDate.now().equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[0][0].getChildren().add(tempCheck);
            } else if (LocalDate.now().plusDays(1).equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[0][1].getChildren().add(tempCheck);
            } else if (LocalDate.now().plusDays(2).equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[0][2].getChildren().add(tempCheck);
            } else if (LocalDate.now().plusDays(3).equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[1][0].getChildren().add(tempCheck);
            } else if (LocalDate.now().plusDays(4).equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[1][1].getChildren().add(tempCheck);
            } else if (LocalDate.now().plusDays(5).equals(Main.assignmentsList.get(i).getDueDate())) {
                rectanglePanes[1][2].getChildren().add(tempCheck);
            }
        }
    }


    private class RemoveButtonHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            for (int i = 0; i < stringToRemove.size(); i++) {
                for (int j = 0; j < Main.assignmentsList.size(); j++)
                    if (stringToRemove.get(i).equalsIgnoreCase(Main.assignmentsList.get(j).getAssignmentName())) {
                        Main.assignmentsList.remove(j);
                    }
            }
            TodayPane.updateTodayPane();
            updateWeeklyPane();
            AllAssignmentsPane.updateAllAssignmentsPane();
        }
    }


    private static class SelectionHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {

            CheckBox activeBox = (CheckBox) event.getSource(); //Save the source of the event to CheckBox object
            if (activeBox.isSelected())
                stringToRemove.add(activeBox.getText());
        }

    }


    //Method to return string with first letter capitalized
    public String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
