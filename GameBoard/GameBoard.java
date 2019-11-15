import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//import Characters.Character;

public class GameBoard extends Application {

    private BorderPane[] borders = {
            /*upper floor*/ new BorderPane(),
            /*main floor*/new BorderPane(),
            /*Basement*/ new BorderPane()
    };
    private String[] titles = {"Upper Floor", "Ground Floor", "Basement"};

    private GridPane[] gridPanes = {
            /*upper floor*/ new GridPane(),
            /*main floor*/ new GridPane(),
            /*Basement*/ new GridPane()
    };

    private Button[] buttons = new Button[3];
    private String[] images = {"UpperLanding.png", "GroundStairs.png", "Basement.png"};
    private Scene[] scenes = new Scene[3];

    private Stairs[] stairs = new Stairs[3];

    private Stage stage;

    private GridPane rightPane = new GridPane();
    private HBox buttonPane = new HBox();

    private Button up = new Button("Go Up");
    private Button down = new Button("Go Down");

    public void start(Stage stage) {
        this.stage = stage;


        // creates the different borderPanes for each Floor


        for (int j = 0; j < borders.length; j++) {

            stairs[j] = new Stairs(images[j]);

            // creates the scene for each floor
            scenes[j] = new Scene(borders[j], 1000, 600);
            // puts each gridPane in the center of the borderPane for each floor
            borders[j].setCenter(gridPanes[j]);
            // adds images to each gridPane
            gridPanes[j].add(stairs[j].image(), 0, 5);


            if(j == 1) {
                gridPanes[j].add(new ImageView("GroundHall.png"), 1, 5);
                gridPanes[j].add(new ImageView("GroundEntrance.png"), 2, 5);
            }
            // adds all the buttons to change between floors
            buttons[j] = new Button(titles[j]);
        }




        // This is the HBox that keeps track of the buttons
        for (Button i : buttons) {
            buttonPane.getChildren().add(i);
        }
        borders[1].setTop(buttonPane);


        Circle circle = new Circle(20);
//        character.setFill(Color.PINK);
        circle.setFill(Color.PINK);
        BugBoy character = new BugBoy();
//        int x = 0;
//        int y = 5;
        gridPanes[1].add(character.image, character.x, character.y);


        Button[] dirBut = {new Button("N"), new Button("W"), new Button("E"), new Button("S")};


        rightPane.add(dirBut[1], 1, 3);
        rightPane.add(dirBut[0], 2, 2);
        rightPane.add(dirBut[3], 2, 4);
        rightPane.add(dirBut[2], 3, 3);

        borders[1].setRight(rightPane);
        dirBut[0].setOnMouseClicked(event -> {
            gridPanes[1].getChildren().remove(character.image);
            gridPanes[1].add(character.image, character.x, --character.y );
        });
        dirBut[1].setOnMouseClicked(event -> {
            gridPanes[1].getChildren().remove(character.image);
            gridPanes[1].add(character.image, --character.x, character.y );
        });
        dirBut[2].setOnMouseClicked(event -> {
            gridPanes[1].getChildren().remove(character.image);
            gridPanes[1].add(character.image, ++character.x, character.y );
        });
        dirBut[3].setOnMouseClicked(event -> {
            gridPanes[1].getChildren().remove(character.image);
            gridPanes[1].add(character.image, character.x, ++character.y );
        });


        for (int z = 0; z < scenes.length; z++) {
            int index = z;
            scenes[index].setOnKeyPressed(event -> {
                if (index == character.lvl /*&& character.moveCount > 0*/) {
                    --character.moveCount;
                    switch (event.getCode()) {
                        case W:
                            --character.y;
                            break;
                        case S:
                            ++character.y;
                            break;
                        case A:
                            --character.x;
                            break;
                        case D:
                            ++character.x;
                            break;
                    }


                    gridPanes[character.lvl].getChildren().remove(character.image);
                    gridPanes[character.lvl].add(character.image, character.x, character.y);


                    up.setOnMouseClicked(e -> {
                        setStairs(true, character, up, down);
                    });
                    down.setOnMouseClicked(el -> {
                        setStairs(false, character, up, down);
                    });


                    if (character.y == stairs[character.lvl].y) {
                        if (character.x == stairs[character.lvl].x) {
                            stairs[character.lvl].upDown(rightPane, index, up, down);
                        }
                        else {
                            gridPanes[character.lvl].getChildren().remove(up);
                            gridPanes[character.lvl].getChildren().remove(down);
                        }
                    }

                }
            });
        }



        // This adds the mouse click for each button to change between scenes.
        for(int i = 0; i < borders.length; i++) {
            int index = i;
            buttons[i].setOnMouseClicked(event -> setScene(index));
        }

        stage.setScene(scenes[1]);
        stage.setTitle("Ground Floor");
        stage.show();

    }

    private void setStairs(boolean minus, Character character, Button up, Button down) {

//        if(stairs[character.lvl].pane >= 0 && stairs[character.lvl].pane < 4) {
            if (character.y == stairs[character.lvl].y) {

                if (character.x == stairs[character.lvl].x) {

                    if (character.lvl >= 0 && character.lvl < 4) {
                        gridPanes[character.lvl].getChildren().remove(character.image);
                        if (minus) {
                            character.lvl--;
//                            stairs[character.lvl].pane--;
                        }
                        else {
                            character.lvl++;
//                            stairs[character.lvl].pane++;
                        }

//                        if(character.lvl >= 0 && character.lvl < 4) {
//                        stairs[character.lvl].pane
                        gridPanes[character.lvl].add(character.image, 0, 5);
                        setScene(character.lvl);

//                        }

                    }
                }
                else {
                    rightPane.getChildren().remove(up);
                    rightPane.getChildren().remove(down);
                }
//            }

        }
            else {
                rightPane.getChildren().remove(up);
                rightPane.getChildren().remove(down);
            }
    }


    private void setScene(int index) {
        borders[index].setRight(rightPane);
        borders[index].setTop(buttonPane);
        stage.setScene(scenes[index]);
        stage.setTitle(titles[index]);
        stage.show();


    }


    public static void main(String[] args) { launch(args); }


}
