import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Runner extends Application {

    public void start(Stage stage) {

        BorderPane pane = new BorderPane();
        CallBoard board = new CallBoard();
        Scene scene = new Scene(pane, 1000, 600);

        TheFrogSlayer character = new TheFrogSlayer();

        stage.setScene(scene);
        board.run(stage, pane, character);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
