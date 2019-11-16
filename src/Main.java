import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Character user;

    public Pane CharacterSelect(){
        Character[] characters = {
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
        Pane backdrop = new Pane();
        BorderPane front = new BorderPane();
        backdrop.getChildren().add(front);
        VBox characterGroup = new VBox();
        front.setCenter(characterGroup);

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
            button.setOnAction(e -> {
                front.setRight(text);
                Button playCharacter = new Button("Play Character");
                VBox description = new VBox();
                description.getChildren().addAll(text, playCharacter);
                front.setRight(description);

                playCharacter.setOnAction(v ->{
                    user = i;
                    backdrop.getChildren().clear();
                });

            });
            characterGroup.getChildren().add(button);
        }
        return backdrop;
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