import GameBoard.GameBoard;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Characters.Character;
import Characters.*;
import Server.Server;

public class ClientPlayer extends Application {

    Stage st = new Stage();


    public void start(Stage stage) throws Exception{
        BorderPane game = new BorderPane();
        CharacterSelect select = new CharacterSelect();
        game.setCenter(select.select(game, st, true));
        Scene scene = new Scene(game, 500, 350);
        st.setTitle("Character Select - Client");
        st.setScene(scene);
        //st.setMaximized(true);
        st.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}