package GameBoard;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Characters.Character;

import java.util.ArrayList;
import java.util.Collections;

public class GameBoard {

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
    private Tile[][][] boardTiles = new Tile[3][100][100];

    public void run(Stage stage, BorderPane pane, Character character) {
        Tile[] upTiles = {
                new Tile(new ImageView("GameBoard/tiles_images/E.png"), false, false, false, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/EW.png"), false, false, false, true, true),
                new Tile(new ImageView("GameBoard/tiles_images/EWS.png"), false, false, true, true, true),
                new Tile(new ImageView("GameBoard/tiles_images/N.png"), false, true, false, false, false),
                new Tile(new ImageView("GameBoard/tiles_images/NE.png"), false, true, false, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/NES.png"), false, true, true, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/NEWS.png"), false),
                new Tile(new ImageView("GameBoard/tiles_images/NS.png"), false, true, true, false, false),
                new Tile(new ImageView("GameBoard/tiles_images/NW.png"), false, true, false, true, false),
                new Tile(new ImageView("GameBoard/tiles_images/NWS.png"), false, true, true, true, false),
                new Tile(new ImageView("GameBoard/tiles_images/S.png"), false, false, true, false, false),
                new Tile(new ImageView("GameBoard/tiles_images/SE.png"), false, false, true, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/SW.png"), false, false, true, true, false),
                new Tile(new ImageView("GameBoard/tiles_images/SWE.png"), false, false, true, true, true),
                new Tile(new ImageView("GameBoard/tiles_images/W.png"), false, false, false, true, false)
        };


        this.pane = pane;

        // this adds the stair tiles to each floor
        for (int j = 0; j < gridPanes.length; j++) {

            Stairs stair =  new Stairs(images[j], true, true, true, true);
            stair.image().setFitWidth(200);
            stair.image().setFitHeight(200);
            boardTiles[j][0][5] = stair;
            stairs[j] = stair;
            gridPanes[j].add(stairs[j].image(), 0, 5);

            // This sets the gridPanes to have the groundHall and the Entrance tiles
            if(j == 1) {
                stair = new Stairs(images[j], false, false, false, true);
                stair.image().setFitWidth(200);
                stair.image().setFitHeight(200);
                stairs[j] = stair;
                boardTiles[j][0][5] = stair;

                Tile tile = new Tile(new ImageView("GameBoard/GroundHall.png"),
                        false, true, true, true, true);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][1][5] = tile;
                gridPanes[j].add(tile.image(), 1, 5);
                tile = new Tile(new ImageView("GameBoard/GroundEntrance.png"),
                        false, true, true, true, true);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][2][5] = tile;
                gridPanes[j].add(tile.image(), 2, 5);
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


        ArrayList<Integer> added = new ArrayList<>();
        stage.getScene().setOnKeyPressed(event -> {
            int choice = (int)(Math.random() * upTiles.length);
            while (added.contains(choice)) {
                choice = (int)(Math.random() * upTiles.length);
            }
            if (gridPanes[onPane] == pane.getCenter()/* && character.move >= 0*/) {
//                Collections.shuffle(upTiles);

                boolean door = false;
                switch (event.getCode()) {
                    case W:
                        if(boardTiles[onPane][character.getX()][character.getY()].nDr) {
                            door = true;
                            character.setY(character.getY() - 1);
                        }
                        break;
                    case S:
                        if(boardTiles[onPane][character.getX()][character.getY()].sDr) {
                            door = true;
                            character.setY(character.getY() + 1);
                        }
                        break;
                    case A:
                        if(boardTiles[onPane][character.getX()][character.getY()].wDr) {
                            door = true;
                            character.setX(character.getX() - 1);
                        }
                        break;
                    case D:
                        if(boardTiles[onPane][character.getX()][character.getY()].eDr) {
                            door = true;
                            character.setX(character.getX() + 1);
                        }
                        break;
                }
                GridPane center = (GridPane) pane.getCenter();
                if(door) {
                    if(boardTiles[onPane][character.getX()][character.getY()] == null) {
                        added.add(choice);
                        upTiles[choice].image().setFitHeight(200);
                        upTiles[choice].image().setFitWidth(200);
                        center.add(upTiles[choice].image(), character.getX(), character.getY());
                        boardTiles[onPane][character.getX()][character.getY()] = upTiles[choice];
                    }

                    center.getChildren().remove(character.getImage());
                    center.add(character.getImage(), character.getX(), character.getY());
                    character.setMoveCount(character.getMoveCount() - 1);
                }
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
