import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private HBox mainView;

    public void start(Stage stage1){

        mainView = new MainView();

        Scene scene1 = new Scene(mainView, 900, 400);

        stage1.setScene(scene1);
        stage1.setTitle("Your Agenda");
        stage1.show();
    }

}
