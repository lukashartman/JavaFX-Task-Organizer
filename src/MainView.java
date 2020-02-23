import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainView extends HBox {

    private VBox leftPane;

    public MainView (){

        leftPane = new LeftPane();

        this.getChildren().addAll(leftPane);
    }

}
