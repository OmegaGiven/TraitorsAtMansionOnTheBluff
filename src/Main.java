import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;


public class Main extends Application {

    public FlowPane CharacterSelect(){

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
        BorderPane forbackdrop = new BorderPane();
        FlowPane backdrop = new  FlowPane();
        forbackdrop.setCenter(backdrop);
        for (Character i: characters){
            Button button = new Button("Select " + i.getName() );
            Button character = new Button(i.getName() + "Description");
            BorderPane x = new BorderPane();
            Text text = new Text(
                i.getName() + "\n" +
                i.getBio() + "\n" +
                "Knowledge: " + i.getKnowledge() + "\n" +
                "Sanity: " + i.getSanity() + "\n" +
                "Speed: " + i.getSpeed() + "\n" +
                "Might: " + i.getMight() + "\n"
            );
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });

            x.setCenter(button);
            x.setBottom(character);
            backdrop.getChildren().add(x);
        }




        return backdrop;

    }

    public void start(Stage stage){

        Scene scene = new Scene(CharacterSelect());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}