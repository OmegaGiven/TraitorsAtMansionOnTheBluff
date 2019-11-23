package GameBoard;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Characters.Character;

public class CallBoard {

    private String[] titles = {"Upper Floor", "Ground Floor", "Basement"};

    private GridPane[] gridPanes = {
            /*upper floor*/ new GridPane(),
            /*main floor*/ new GridPane(),
            /*Basement*/ new GridPane()
    };

    private Button[] buttons = new Button[3];
    private String[] images = {"GameBoard/UpperLanding.png", "GameBoard/GroundStairs.png", "GameBoard/Basement.png"};

    private Stairs[] stairs = new Stairs[3];

    private VBox rightPane = new VBox();
    private HBox buttonPane = new HBox();

    private Button up = new Button("Go Up");
    private Button down = new Button("Go Down");

    private BorderPane pane;

    // this variable just keeps track of what pane the player is on right now.S
    private int onPane;

    public void run(Stage stage, BorderPane pane, Character character) {


//        Tile[] upTiles = {
//                new Tile(new ImageView("tiles_images/E.png"), false, false, false, false, true),
//                new Tile(new ImageView("tiles_images/EW.png"), false, false, false, true, true),
//                new Tile(new ImageView("tiles_images/EWS.png"), false, false, true, true, true),
//                new Tile(new ImageView("tiles_images/N.png"), false, true, false, false, false),
//                new Tile(new ImageView("tiles_images/NE.png"), false, true, false, false, true),
//                new Tile(new ImageView("tiles_images/NES.png"), false, true, true, false, true),
//                new Tile(new ImageView("tiles_images/NEWS.png"), false),
//                new Tile(new ImageView("tiles_images/NS.png"), false, true, true, false, false),
//                new Tile(new ImageView("tiles_images/NW.png"), false, true, false, true, false),
//                new Tile(new ImageView("tiles_images/NWS.png"), false, true, true, true, false),
//                new Tile(new ImageView("tiles_images/S.png"), false, false, true, false, false),
//                new Tile(new ImageView("tiles_images/SE.png"), false, false, true, false, true),
//                new Tile(new ImageView("tiles_images/SW.png"), false, false, true, true, false),
//                new Tile(new ImageView("tiles_images/SWE.png"), false, false, true, true, true),
//                new Tile(new ImageView("tiles_images/W.png"), false, false, false, true, false)
//        };


        this.pane = pane;

        // this adds the stair tiles to each floor
        for (int j = 0; j < gridPanes.length; j++) {

            stairs[j] = new Stairs(images[j], true, true, true, true);

            gridPanes[j].add(stairs[j].image(), 0, 5);

            // This sets the gridPanes to have the groundHall and the Entrance tiles
            if(j == 1) {
                stairs[j] = new Stairs(images[j], false, false, false, true);
                gridPanes[j].add(new Tile(new ImageView("GameBoard/GroundHall.png"),
                        false, true, true, true, true).image(), 1, 5);
                gridPanes[j].add(new Tile(new ImageView("GameBoard/GroundEntrance.png"),
                        false, true, true, true, true).image(), 2, 5);
            }

            // adds all the buttons to change between floors
            buttons[j] = new Button(titles[j]);
            int index = j;
            buttons[j].setOnMouseClicked(event -> pane.setCenter(gridPanes[index]));
        }



        // This is the HBox that keeps track of the buttons
        for (Button i : buttons) {
            buttonPane.getChildren().add(i);
        }
        pane.setTop(buttonPane);

        gridPanes[1].add(character.getImage(), character.getX(), character.getY());

        rightPane.getChildren().add(up);
        rightPane.getChildren().add(down);
        pane.setRight(rightPane);


        stage.getScene().setOnKeyPressed(event -> {
            if (gridPanes[onPane] == pane.getCenter()/* && character.move >= 0*/) {
//                int choice = (int)(Math.random() * upTiles.length);
                switch (event.getCode()) {
                    case W:
                        character.setY(character.getY() - 1);
                        break;
                    case S:
                        character.setY(character.getY() + 1);
                        break;
                    case A:
                        character.setX(character.getX() - 1);
                        break;
                    case D:
                        character.setX(character.getX() + 1);
                        break;
                }
                GridPane center = (GridPane) pane.getCenter();
                center.getChildren().remove(character.getImage());
//                center.add(upTiles[choice].image(), character.getX(), character.getY());
                center.add(character.getImage(), character.getX(), character.getY());
                character.setMoveCount(character.getMoveCount() - 1);
            }

        });

        // this sets the up button so when pressed the character goes "up" the stairs.
        up.setOnMouseClicked(e -> {
            if (character.getY() == 5 && character.getX() == 0) {
                for (int i = 0; i < gridPanes.length; i++) {
                    if (pane.getCenter() == gridPanes[i]) {
                        if(setStairs(true, character, i)){
                            break;
                        }
                    }
                }
            }
        });

        // this set the down button so when pressed the character goes "down" the stairs.
        down.setOnMouseClicked(el -> {
            if (character.getY() == 5 && character.getX() == 0) {
                for (int i = 0; i < gridPanes.length; i++) {
                    if (pane.getCenter() == gridPanes[i]) {
                        if(setStairs(false, character, i)) {
                            break;
                        }
                    }
                }
            }
        });

        onPane = 1;
        pane.setCenter(gridPanes[1]);

    }

    private boolean setStairs(boolean minus, Character character, int index) {
        if (minus && index >= 0 && index < 3 && index - 1 >= 0 || !minus && index >= 0 && index < 3 && index + 1 < 3) {
            gridPanes[index].getChildren().remove(character.getImage());
            if (minus) {
                onPane--;
                index--;
            } else {
                onPane++;
                index++;
            }

            gridPanes[index].add(character.getImage(), 0, 5);
            pane.setCenter(gridPanes[index]);
            return true;
        }
        return false;
    }

}
