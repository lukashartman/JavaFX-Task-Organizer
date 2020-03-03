
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

public class WeeklyPane extends GridPane {

    private Label testLabel, testLabel2;
    private LeftPane leftPane;
    private MainPane mainPane;

    public WeeklyPane(LeftPane leftPane, MainPane mainPane) {
        this.mainPane = mainPane;
        this.leftPane = leftPane;


    }
}
