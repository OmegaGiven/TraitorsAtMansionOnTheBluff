package GameBoard;
import Characters.BugBoy;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import Characters.Character;
import Card.Card;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class GameBoard {

    private String[] titles = {"Upper Floor", "Ground Floor", "Basement"};
    Character opponent = new Character();
    Socket socketClient = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;


    private GridPane[] gridPanes = {
            /*upper floor*/ new GridPane(),
            /*main floor*/ new GridPane(),
            /*Basement*/ new GridPane()
    };

    private Button[] buttons = new Button[3];
    private String[] images = {"GameBoard//tiles_images/UPPER_LANDING.png", "GameBoard/tiles_images/GROUND_FLOOR_STAIRCASE.png", "GameBoard/tiles_images/BASEMENT.png"};

    private Tile[] stairs = new Tile[3];

    private ScrollPane right = new ScrollPane();
    private ScrollPane left = new ScrollPane();

    private VBox rightPane = new VBox(); // contains up/down buttons and chatbox/narration
    private VBox leftPane = new VBox(); // contains stats and player's items
    private HBox buttonPane = new HBox(); // contains level buttons

    private Button up = new Button("Go Up");
    private Button down = new Button("Go Down");
    private Button attack = new Button("Attack");
    private Button weaponSelect = new Button("Select Weapon");
    private Text selectedWeapon = new Text();
    private Button endTurn = new Button("End Turn");
    private Stage weapons = new Stage();

    private VBox items = new VBox();
    private VBox stats = new VBox();
    private VBox omens = new VBox();

    private int sCount = 0;
    private int moves = 0;

    private Tile[][][] boardTiles = new Tile[3][1000][1000];
    private ScrollPane scrollPane = new ScrollPane();

    // this variable just keeps track of what pane the player is on right now.
    private int onPane;
    private boolean move = true;

    private boolean spook = false;
    private int stairX = 500;
    private int stairY = 500;

    public void connect() throws Exception {
        try {
            ServerSocket srvr = new ServerSocket(5558);
            socketClient = srvr.accept();
            System.out.println("Server: " + "Connection Established");

        } catch (Exception ex) {
            System.err.println(ex + "Client couldn't connect");
        }

        oos = new ObjectOutputStream(socketClient.getOutputStream());
        ois = new ObjectInputStream(socketClient.getInputStream());

        reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
    }

    public void clientConnect() throws Exception {
        try {
            socketClient = new Socket("localhost",5558);
            System.out.println("Server: " + "Connection Established");
        } catch (Exception ex) {
            System.err.println(ex + "Client couldn't connect");
        }
        oos = new ObjectOutputStream(socketClient.getOutputStream());
        ois = new ObjectInputStream(socketClient.getInputStream());

        reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
    }

    public void sendObject(Character player) throws IOException, ClassNotFoundException {
        oos.writeObject(player);
        oos.flush();

        opponent = (Character)ois.readObject();
    }

    public void receiveCharacter() throws Exception {
        opponent.setX(Integer.parseInt(reader.readLine().trim()));
        opponent.setY(Integer.parseInt(reader.readLine().trim()));
        opponent.setName(reader.readLine().trim());
        opponent.setBio(reader.readLine().trim());
        opponent.setAge(Integer.parseInt(reader.readLine().trim()));
        opponent.setMoveCount(Integer.parseInt(reader.readLine().trim()));
        opponent.setSpeed(Integer.parseInt(reader.readLine().trim()));
        opponent.setMight(Integer.parseInt(reader.readLine().trim()));
        opponent.setSanity(Integer.parseInt(reader.readLine().trim()));
        opponent.setKnowledge(Integer.parseInt(reader.readLine().trim()));

    }

    public void sendCharacter(Character player) throws Exception {
        ImageView image = player.getImage();
        String name = player.getName();
        String bio = player.getBio();
        int age = player.getAge();
        int x = player.getX();
        int y = player.getY();
        int moveCount = player.getMoveCount();
        int speed = player.getSpeed();
        int might = player.getMight();
        int sanity = player.getSanity();
        int knowledge = player.getKnowledge();

        writer.write(x+"\r\n");
        writer.write(y+"\r\n");
        //writer.write(image+"\r\n");
        writer.write(name+"\r\n");
        writer.write(bio+"\r\n");
        writer.write(age+"\r\n");
        writer.write(moveCount+"\r\n");
        writer.write(speed+"\r\n");
        writer.write(might+"\r\n");
        writer.write(sanity+"\r\n");
        writer.write(knowledge+"\r\n");
        writer.flush();
    }

    public void testReceiveFirst() throws Exception {

        String response = reader.readLine().trim();
        System.out.println("Message: " + response);
    }

    public void testSendReceive() throws Exception {
        writer.write("Server Made a move\r\n");
        writer.flush();

        String response = reader.readLine().trim();
        System.out.println("Message: " + response);
    }




    public void run(Scene scene, BorderPane pane, Character character, Boolean servr) throws Exception {
        moves = character.getSpeed();


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
            boardTiles[j][stairX][stairY] = stair;
            stairs[j] = stair;
            gridPanes[j].add(stairs[j].image(), stairX, stairY);

            // This sets the gridPanes to have the groundHall and the Entrance tiles
            if(j == 1) {
                // this sets up the stairs for the ground floor
                stair = new Tile(new ImageView(images[j]), false, false, false, false, true);
                stair.image().setFitWidth(200);
                stair.image().setFitHeight(200);
                stairs[j] = stair;
                boardTiles[j][stairX][stairY] = stair;

                // this sets up the middle tile of the ground floor
                Tile tile = new Tile(new ImageView("GameBoard/tiles_images/HALLWAY.png"), false);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][stairX + 1][stairY] = tile;
                gridPanes[j].add(tile.image(), stairX + 1, stairY);

                // this sets up the far right tile of the ground floor
                tile = new Tile(new ImageView("GameBoard/tiles_images/ENTRANCE_HALL.png"), false);
                tile.image().setFitWidth(200);
                tile.image().setFitHeight(200);
                boardTiles[j][stairX + 2][stairY] = tile;
                gridPanes[j].add(tile.image(), stairX + 2, stairY);
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


        /*
        if(servr){
            receiveCharacter();
            sendCharacter(character);
        }
        else {
            sendCharacter(character);
            receiveCharacter();
        }
        gridPanes[1].add(opponent.getImage(), opponent.getX() - 1, opponent.getY());
        gridPanes[1].setHalignment(opponent.getImage(), HPos.CENTER);

         */

        // add the up and down buttons for the right side of the pane.
        rightPane.getChildren().add(up);
        rightPane.getChildren().add(down);
        rightPane.getChildren().add(attack);
        rightPane.getChildren().add(endTurn);
        Text logTitle = new Text("===== EVENT LOG =====");
        logTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        rightPane.getChildren().add(logTitle);
        right.setContent(rightPane);
        pane.setRight(right);

        // add stats and item boxes to left side of pane
        Text statsTitle = new Text("====== STATS ======");
        statsTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        stats.getChildren().add(statsTitle);
        Text movesLeft = new Text("MOVES LEFT        :    " + moves);
        movesLeft.setFill(Color.DARKBLUE);
        stats.getChildren().add(movesLeft);
        Text statistics = new Text(character.getStats());
        stats.getChildren().add(statistics);
        leftPane.getChildren().add(stats);
        Text itemsTitle = new Text("====== ITEMS ======");
        itemsTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        items.getChildren().add(itemsTitle);
        leftPane.getChildren().add(items);
        Text omen = new Text("====== OMENS ======");
        omen.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        Text spookCount = new Text("SPOOK COUNT: " + sCount);
        spookCount.setFill(Color.CRIMSON);
        leftPane.getChildren().add(omen);
        leftPane.getChildren().add(spookCount);
        leftPane.getChildren().add(omens);
        left.setContent(leftPane);
        pane.setLeft(left);

        ArrayList[] added = new ArrayList[3];
        scene.setOnKeyPressed(event -> {
            Text card = new Text();
            // this is for choosing a random tile.
            int choice = (int)(Math.random() * allTiles.length);
            // this just makes sure that there are no duplicates.
            while (added[onPane].contains(choice) && added[onPane].size() != allTiles.length) {
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
                                        && added[onPane].size() != allTiles.length) {

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
                                        && added[onPane].size() == allTiles.length) {

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
                                        && added[onPane].size() != allTiles.length) {

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
                                        && added[onPane].size() == allTiles.length) {

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
                                        && added[onPane].size() != allTiles.length) {

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
                                        && added[onPane].size() == allTiles.length) {

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
                                        && added[onPane].size() != allTiles.length) {

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
                                        && added[onPane].size() == allTiles.length) {
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
                            added[onPane].add(choice);
                            allTiles[choice].image().setFitHeight(200);
                            allTiles[choice].image().setFitWidth(200);
                            center.add(allTiles[choice].image(), character.getX(), character.getY());
                            boardTiles[onPane][character.getX()][character.getY()] = allTiles[choice];
                            card.setText(allTiles[choice].card.toString());
                            rightPane.getChildren().remove(card);
                            if(allTiles[choice].card.getType().equals("Item")){
                                ImageView im = allTiles[choice].card.getImage();
                                im.setFitWidth(90);
                                im.setFitHeight(90);
                                items.getChildren().add(im);
                                items.getChildren().add(card);
                                character.addItem(allTiles[choice].card);
                            }
                            else if(allTiles[choice].card.getType().equals("Omen")){
                                if(!spook){
                                    ImageView im = allTiles[choice].card.getImage();
                                    im.setFitWidth(90);
                                    im.setFitHeight(90);
                                    omens.getChildren().add(im);
                                    omens.getChildren().add(card);
                                    sCount++;
                                    spookCount.setText("SPOOK COUNT: " + sCount);
                                    if(sCount == 4){
                                        spook = true;
                                        character.setTraitor(true);
                                        Text spookLog = new Text("SPOOK TRIGGERED");
                                        spookLog.setFill(Color.RED);
                                        spookLog.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
                                        rightPane.getChildren().add(spookLog);
                                        Text spookText = new Text("Your new objective:\nKILL THE OTHER PLAYER\n");
                                        spookText.setFill(Color.RED);
                                        rightPane.getChildren().add(spookText);
                                    }
                                }
                            }
                            else{
                                rightPane.getChildren().add(card);
                                //int damage = allTiles[choice].card.getDamage();
                                int damage = -1;
                                switch(allTiles[choice].card.getCategory()) {
                                    case "speed":
                                        character.changeSpeed(damage);
                                        break;
                                    case "might":
                                        character.changeMight(damage);
                                        break;
                                    case "sanity":
                                        character.changeSanity(damage);
                                        break;
                                    case "knowledge":
                                        character.changeKnowledge(damage);
                                        break;
                                }
                                stats.getChildren().remove(statistics);
                                statistics.setText(character.getStats());
                                stats.getChildren().add(statistics);

                            }
                    }

                    if (move) {
                        // this is the part that moves the character.
                        center.getChildren().remove(character.getImage());
                        // this adds the character image to the pane
                        center.add(character.getImage(), character.getX(), character.getY());
                        // this makes the character image in the center of the tile
                        gridPanes[1].setHalignment(character.getImage(), HPos.CENTER);
                        character.setMoveCount(character.getMoveCount() - 1);
                        moves--;
                        movesLeft.setText("MOVES LEFT        :    " + moves);
                    }
                }
            }

        });


        // END TURN BUTTON
        endTurn.setOnMouseClicked(e ->{
            Text end = new Text(character.getName() + " has ended \ntheir turn...\n");
            end.setFill(Color.DARKGREEN);
            rightPane.getChildren().add(end);
            moves = character.getSpeed();
            movesLeft.setText("MOVES LEFT        :    " + moves);
            // where information will be sent over for server

            try {
                testSendReceive();
                //sendObject(character);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        });

        // attack button
        attack.setOnMouseClicked(e ->{
            weapons.setTitle("Weapon Select");
            BorderPane wPane = new BorderPane();
            ScrollPane cardScroll = new ScrollPane();
            FlowPane cards = new FlowPane();
            cards.setMaxWidth(400);
            VBox select = new VBox();
            for(Card c : character.getCards()){
                Text t = new Text(c.toString());
                ImageView i = c.getImage();
                VBox it = new VBox();
                it.getChildren().add(i);
                it.getChildren().add(t);
                i.setFitHeight(90);
                i.setFitWidth(90);
                cards.getChildren().add(it);
                Button b = new Button(c.getCardName());
                b.setOnMouseClicked(o ->{
                    weapons.setTitle("Weapon Select - " + b.getText().toUpperCase() + " SELECTED");
                    selectedWeapon.setText(character.getName() + " used\n" + b.getText() + "\n");
                });
                select.getChildren().add(b);
            }
            cardScroll.setContent(cards);
            select.getChildren().add(new Text("\n\n\n\n"));
            select.getChildren().add(weaponSelect);
            wPane.setLeft(select);
            wPane.setCenter(new Text("             "));
            wPane.setRight(cardScroll);
            weaponSelect.setOnMouseClicked(v ->{
                weapons.close();
                selectedWeapon.setFill(Color.MAROON);
                Text nW = new Text(selectedWeapon.getText()); // janky workaround so multiple weapon uses show up as separate events
                nW.setFill(Color.MAROON);
                rightPane.getChildren().add(nW);

            });
            Scene scene1 = new Scene(wPane, 500, 350);
            weapons.setScene(scene1);
            weapons.show();
        });

        // this sets the up button so when pressed the character goes "up" the stairs.
        up.setOnMouseClicked(e -> {
            if (character.getY() == stairY && character.getX() == stairX) {
                for (int i = 0; i < gridPanes.length; i++) {
                    if (/*pane.getCenter()*/scrollPane.getContent() == gridPanes[i]) {
                        if(setStairs(true, character, i)){
                            break;
                        }
                    }
                }
            }
            moves--;
            movesLeft.setText("MOVES LEFT        :    " + moves);
        });

        // this set the down button so when pressed the character goes "down" the stairs.
        down.setOnMouseClicked(el -> {
            if (character.getY() == stairY && character.getX() == stairX) {
                for (int i = 0; i < gridPanes.length; i++) {
                    if (scrollPane.getContent()/*pane.getCenter()*/ == gridPanes[i]) {
                        if(setStairs(false, character, i)) {
                            break;
                        }
                    }
                }
            }
            moves--;
            movesLeft.setText("MOVES LEFT        :    " + moves);
        });

        onPane = 1;

        scrollPane.setContent(gridPanes[1]);

        if (servr) {
            testReceiveFirst();
        }

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
            gridPanes[index].add(character.getImage(), character.getX(), character.getY());
            // this makes the character image in the center of the tile
            gridPanes[1].setHalignment(character.getImage(), HPos.CENTER);
            scrollPane.setContent(gridPanes[index]);
            return true;
        }
        return false;
    }

}
