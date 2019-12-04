import GameBoard.GameBoard;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    Character user = new Character();
//    boolean selection = false;

    public Pane CharacterSelect(BorderPane game) throws Exception{
        Server server = new Server();
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
            Text name = new Text(i.getName());
            name.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

            Text bio = new Text(i.getBio());
            bio.setFont(Font.font("Verdana", FontPosture.ITALIC, 11));

            ImageView pic = i.getImage();

            Text stats = new Text(
                    "Knowledge: " + i.getKnowledge() + "\n" +
                            "Sanity: " + i.getSanity() + "\n" +
                            "Speed: " + i.getSpeed() + "\n" +
                            "Might: " + i.getMight() + "\n"
            );

            VBox text = new VBox();
            text.getChildren().addAll(name, bio, stats, pic);

            Character current = i;
            button.setOnAction(e -> {
                front.setRight(text);
                Button playCharacter = new Button("Play Character");
                VBox description = new VBox();
                description.getChildren().addAll(text, playCharacter);
                front.setRight(description);

                playCharacter.setOnAction(v ->{
                    System.out.println(i.getName());
                    user = current;
                    backdrop.getChildren().clear();
                    //game.setRight(updateDescription());
                    GameBoard board = new GameBoard();
                    Stage stage = new Stage();
                    BorderPane pane = new BorderPane();
                    Scene scene = new Scene(pane);
                    stage.setMaximized(true);
                    stage.setScene(scene);
                    stage.setTitle("Traitors At Mansion On The Bluff - Client");
                    try {
                        //server.clientConnect();
                        board.run(scene, pane, user, false);

                    } catch (Exception ex){
                        System.err.println(ex);
                    }
                    stage.show();
                    st.close();
                });

            });
            characterGroup.getChildren().add(button);
        }

        return backdrop;
    }

    public VBox updateDescription(){
        VBox userDescription = new VBox();
        Text name = new Text(user.getName());
        Text description = new Text(user.getBio());
        Text knowledge = new Text("Knowledge: "+user.getKnowledge()+"");
        Text sanity = new Text("Sanity: "+user.getSanity()+"");
        Text might = new Text("Might: "+user.getMight()+"");
        Text speed = new Text("Speed: " +
                ""+user.getSpeed()+"");
        userDescription.getChildren().addAll(name,description,knowledge,sanity,might,speed);
        return userDescription;
    }

    public void start(Stage stage) throws Exception{
        BorderPane game = new BorderPane();
        game.setCenter(CharacterSelect(game));
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