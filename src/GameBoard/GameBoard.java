package GameBoard;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Characters.Character;
import java.util.ArrayList;


public class GameBoard {

    private String[] titles = {"Upper Floor", "Ground Floor", "Basement"};

    private GridPane[] gridPanes = {
            /*upper floor*/ new GridPane(),
            /*main floor*/ new GridPane(),
            /*Basement*/ new GridPane()
    };

    private Button[] buttons = new Button[3];
    private String[] images = {"GameBoard/UpperLanding.png", "GameBoard/GroundStairs.png", "GameBoard/Basement.png"};

    private Tile[] stairs = new Tile[3];

    private VBox rightPane = new VBox();
    private HBox buttonPane = new HBox();

    private Button up = new Button("Go Up");
    private Button down = new Button("Go Down");

    private Tile[][][] boardTiles = new Tile[3][100][100];
    private ScrollPane scrollPane = new ScrollPane();

    // this variable just keeps track of what pane the player is on right now.S
    private int onPane;
    private boolean move = true;


    public void run(Scene scene, BorderPane pane, Character character) {

        scrollPane.setContent(pane.getCenter());
        pane.setCenter(scrollPane);


        Tile[] allTiles = {
                new Tile(new ImageView("GameBoard/tiles_images/E.png"), false, false, false, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/EW.png"), false, false, false, true, true),
                new Tile(new ImageView("GameBoard/tiles_images/EWS.png"), false, false, true, true, true),
                new Tile(new ImageView("GameBoard/tiles_images/N.png"), false, true, false, false, false),
                new Tile(new ImageView("GameBoard/tiles_images/NE.png"), false, true, false, false, true),
                new Tile(new ImageView("GameBoard/tiles_images/NES.png"), false, true, true, true, false),
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



        // this adds the stair tiles to each floor
        for (int j = 0; j < gridPanes.length; j++) {
            // this sets up the basement and upper floor stair tiles.
            Tile stair =  new Tile(new ImageView(images[j]), false, true, true, true, true);
            stair.image().setFitWidth(200);
            stair.image().setFitHeight(200);
            boardTiles[j][0][5] = stair;
            stairs[j] = stair;
            gridPanes[j].add(stairs[j].image(), 0, 5);

            // This sets the gridPanes to have the groundHall and the Entrance tiles
            if(j == 1) {
                // this sets up the stairs for the ground floor
                stair = new Tile(new ImageView(images[j]), false, false, false, false, true);
                stair.image().setFitWidth(200);
                stair.image().setFitHeight(200);
                stairs[j] = stair;
                boardTiles[j][0][5] = stair;

                // this sets up the middle tile of the ground floor
                Tile tile = new Tile(new ImageView("GameBoard/GroundHall.png"), false);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][1][5] = tile;
                gridPanes[j].add(tile.image(), 1, 5);

                // this sets up the far right tile of the ground floor
                tile = new Tile(new ImageView("GameBoard/GroundEntrance.png"), false);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][2][5] = tile;
                gridPanes[j].add(tile.image(), 2, 5);
            }

            // adds all the buttons to change between floors
            buttons[j] = new Button(titles[j]);
            int index = j;
            buttons[j].setOnMouseClicked(event -> scrollPane.setContent(gridPanes[index]));

        }



        // This is the HBox that keeps track of the buttons
        for (Button i : buttons) {
            buttonPane.getChildren().add(i);
        }
        pane.setTop(buttonPane);

        // this adds the character image to the pane
        gridPanes[1].add(character.getImage(), character.getX(), character.getY());
        // this makes the character image in the center of the tile
        gridPanes[1].setHalignment(character.getImage(), HPos.CENTER);

        // add the up and down buttons for the right side of the pane.
        rightPane.getChildren().add(up);
        rightPane.getChildren().add(down);
        pane.setRight(rightPane);


        ArrayList<Integer> added = new ArrayList<>();
        scene.setOnKeyPressed(event -> {
            // this is for choosing a random tile.
            int choice = (int)(Math.random() * allTiles.length);
            // this just makes sure that there are no duplicates.
            while (added.contains(choice) && added.size() != allTiles.length) {
                choice = (int)(Math.random() * allTiles.length);
            }

            move = true;
            if (gridPanes[onPane] == scrollPane.getContent()) {

                // this is the part where it checks for wasd for the movement of the character.
                boolean door = false;
                switch (event.getCode()) {
                    case W:
                        if(boardTiles[onPane][character.getX()][character.getY()].nDr) {
                            door = true;
                            if(move) {
                                character.setY(character.getY() - 1);
                                if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() != allTiles.length) {

                                    //This part is where the tiles get rotated when discovered.
                                    if (allTiles[choice].sDr) {
                                        allTiles[choice].image().setRotate(0);
                                    } else if (allTiles[choice].eDr) {
                                        allTiles[choice].image().setRotate(90);
                                        rotate(allTiles[choice], 1);
                                    } else if (allTiles[choice].nDr) {
                                        allTiles[choice].image().setRotate(180);
                                        rotate(allTiles[choice], 2);
                                    } else {
                                        allTiles[choice].image().setRotate(-90);
                                        rotate(allTiles[choice], 3);
                                    }
                                }
                                else if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() == allTiles.length) {

                                    character.setY(character.getY() + 1);
                                    move = false;
                                }
                            }
                        }
                        break;
                    case S:
                        if(boardTiles[onPane][character.getX()][character.getY()].sDr) {
                            door = true;
                            if(move) {
                                character.setY(character.getY() + 1);
                                if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() != allTiles.length) {

                                    //This part is where the tiles get rotated when discovered.
                                    if (allTiles[choice].nDr) {
                                        allTiles[choice].image().setRotate(0);
                                    } else if (allTiles[choice].wDr) {
                                        allTiles[choice].image().setRotate(90);
                                        rotate(allTiles[choice], 1);
                                    } else if (allTiles[choice].sDr) {
                                        allTiles[choice].image().setRotate(180);
                                        rotate(allTiles[choice], 2);
                                    } else {
                                        allTiles[choice].image().setRotate(-90);
                                        rotate(allTiles[choice], 3);
                                    }
                                }
                                else if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() == allTiles.length) {

                                    character.setY(character.getY() - 1);
                                    move = false;
                                }
                            }
                        }
                        break;
                    case A:
                        if(boardTiles[onPane][character.getX()][character.getY()].wDr) {
                            door = true;
                            if(move) {
                                character.setX(character.getX() - 1);
                                if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() != allTiles.length) {

                                    //This part is where the tiles get rotated when discovered.
                                    if (allTiles[choice].eDr) {
                                        allTiles[choice].image().setRotate(0);
                                    } else if (allTiles[choice].nDr) {
                                        allTiles[choice].image().setRotate(90);
                                        rotate(allTiles[choice], 1);
                                    } else if (allTiles[choice].wDr) {
                                        allTiles[choice].image().setRotate(180);
                                        rotate(allTiles[choice], 2);
                                    } else {
                                        allTiles[choice].image().setRotate(-90);
                                        rotate(allTiles[choice], 3);
                                    }
                                }
                                else if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() == allTiles.length) {

                                    character.setX(character.getX() + 1);
                                    move = false;
                                }
                            }
                        }
                        break;
                    case D:
                        if(boardTiles[onPane][character.getX()][character.getY()].eDr) {
                            door = true;
                            if(move) {
                                character.setX(character.getX() + 1);
                                if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() != allTiles.length) {

                                    //This part is where the tiles get rotated when discovered.
                                    if (allTiles[choice].wDr) {
                                        allTiles[choice].image().setRotate(0);
                                    } else if (allTiles[choice].sDr) {
                                        allTiles[choice].image().setRotate(90);
                                        rotate(allTiles[choice], 1);
                                    } else if (allTiles[choice].eDr) {
                                        allTiles[choice].image().setRotate(180);
                                        rotate(allTiles[choice], 2);
                                    } else {
                                        allTiles[choice].image().setRotate(-90);
                                        rotate(allTiles[choice], 3);
                                    }
                                }
                                else if(boardTiles[onPane][character.getX()][character.getY()] == null
                                        && added.size() == allTiles.length) {
                                    character.setX(character.getX() - 1);
                                    move = false;
                                }

                            }
                        }
                        break;
                }
                GridPane center = (GridPane) scrollPane.getContent();
                if(door) {
                    // this is the part where it adds a new tile.
                    if(boardTiles[onPane][character.getX()][character.getY()] == null && move) {

                            // this is the part where it adds new tiles when moving.
                            added.add(choice);
                            allTiles[choice].image().setFitHeight(200);
                            allTiles[choice].image().setFitWidth(200);
                            center.add(allTiles[choice].image(), character.getX(), character.getY());
                            boardTiles[onPane][character.getX()][character.getY()] = allTiles[choice];
                    }

                    if (move) {
                        // this is the part that moves the character.
                        center.getChildren().remove(character.getImage());
                        // this adds the character image to the pane
                        center.add(character.getImage(), character.getX(), character.getY());
                        // this makes the character image in the center of the tile
                        gridPanes[1].setHalignment(character.getImage(), HPos.CENTER);
                        character.setMoveCount(character.getMoveCount() - 1);
                    }
                }
            }

        });

        // this sets the up button so when pressed the character goes "up" the stairs.
        up.setOnMouseClicked(e -> {
            if (character.getY() == 5 && character.getX() == 0) {
                for (int i = 0; i < gridPanes.length; i++) {
                    if (/*pane.getCenter()*/scrollPane.getContent() == gridPanes[i]) {
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
                    if (scrollPane.getContent()/*pane.getCenter()*/ == gridPanes[i]) {
                        if(setStairs(false, character, i)) {
                            break;
                        }
                    }
                }
            }
        });

        onPane = 1;
        scrollPane.setContent(gridPanes[1]);

    }

    // this rotates the "doors" so that they correspond with the actual doors on the pictures.
    private void rotate(Tile tile, int times) {
        if(times == 0) return;
        boolean temp = tile.nDr;
        tile.nDr = tile.wDr;
        tile.wDr = tile.sDr;
        tile.sDr = tile.eDr;
        tile.eDr = temp;
        rotate(tile, times - 1);
    }

    // this makes the changes when going up and down the stairs.
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

            // this adds the character image to the pane
            gridPanes[index].add(character.getImage(), 0, 5);
            // this makes the character image in the center of the tile
            gridPanes[1].setHalignment(character.getImage(), HPos.CENTER);
            scrollPane.setContent(gridPanes[index]);
            return true;
        }
        return false;
    }

}
