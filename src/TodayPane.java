import com.sun.tools.javac.comp.Check;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.time.LocalDate;


public class TodayPane extends HBox {

    private LeftPane leftPane;
    private MainPane mainPane;
    private Line dividerLine;
    public static VBox todayVbox, tomorrowVbox;
    private Label todayLabel, tomorrowLabel;

    public TodayPane(LeftPane leftPane, MainPane mainPane){
        this.mainPane = mainPane;
        this.leftPane = leftPane;

        todayLabel = new Label("Due Today");
        todayLabel.getStyleClass().add("todayViewHeaderLabels");

        todayVbox = new VBox(todayLabel);
        todayVbox.setPadding(new Insets(5,5,5,15));
        todayVbox.setPrefWidth(350);


        tomorrowLabel = new Label("Due Tomorrow");
        tomorrowLabel.getStyleClass().add("todayViewHeaderLabels");

        tomorrowVbox = new VBox(tomorrowLabel);
        tomorrowVbox.setPadding(new Insets(5,5,5,15));
        tomorrowVbox.setPrefWidth(350);


        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            if (Main.assignmentsList.get(i).getDueDate().equals(LocalDate.now())) {
                todayVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            } else if (Main.assignmentsList.get(i).getDueDate().equals(LocalDate.now().plusDays(1))) {
                tomorrowVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            }
        }

        dividerLine = new Line(350,0,350,400);
        this.getChildren().addAll(todayVbox, dividerLine, tomorrowVbox);

    }

    public static void updateTodayPane() {
        todayVbox.getChildren().removeIf(CheckBox.class::isInstance);
        tomorrowVbox.getChildren().removeIf(CheckBox.class::isInstance);


        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            if (LocalDate.now().equals(Main.assignmentsList.get(i).getDueDate())) {
                todayVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            } else if (LocalDate.now().plusDays(1).equals(Main.assignmentsList.get(i).getDueDate())) {
                tomorrowVbox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
            }
        }
    }

}
