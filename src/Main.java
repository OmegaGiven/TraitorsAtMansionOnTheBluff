import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    public BorderPane CharacterSelect(){
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

        BorderPane backdropsbackdrop = new BorderPane();

        VBox backdrop = new VBox();

        backdropsbackdrop.setCenter(backdrop);

        for (Character i: characters){
            Button button = new Button("Select " + i.getName() );
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
                    backdropsbackdrop.setRight(text);
                }
            });

            backdrop.getChildren().add(button);
        }
        return backdropsbackdrop;
    }

    public void start(Stage stage){
        BorderPane game = new BorderPane();
        game.setCenter(CharacterSelect());
        Scene scene = new Scene(game);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}