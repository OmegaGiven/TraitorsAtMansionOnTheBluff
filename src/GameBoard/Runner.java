package GameBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Characters.*;


public class Runner extends Application {

    public void start(Stage stage) {

        BorderPane pane = new BorderPane();
        GameBoard board = new GameBoard();
        Scene scene = new Scene(pane, 1000, 600);

        TheFrogSlayer character = new TheFrogSlayer();

        stage.setScene(scene);
        board.run(scene, pane, character);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
