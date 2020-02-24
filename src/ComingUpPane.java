
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ComingUpPane extends GridPane {

    private Label testLabel, testLabel2;

    public ComingUpPane(){
        testLabel = new Label("Testing");
        testLabel2 = new Label("Some More");

        this.add(testLabel2, 0, 1);
        this.add(testLabel, 3, 1);
    }


}
