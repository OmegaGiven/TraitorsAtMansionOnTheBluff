import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public void CharacterSelect(){



        Character[] characters =  {
            new BugBoy(),
            new BougieBrain(),
            new PapaKooky(),
            new ProfessorMatricide(),
            new PuppetBoy(),
            new SadBookGirl(),
            new SpeedySir(),
            new SpookyWitchLady(),
            new TheArsonGal(),
            new TheBigBoy(),
            new TheDollKid(),
            new TheFrogSlayer(),
        };

        FlowPane backdrop = new  FlowPane();

    }

    public void start(Stage stage){




    }

    public static void main(String[]args){
        launch(args);
    }
}