package Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Characters.Character;
import Characters.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Server {
    Socket socketClient = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    ServerSocket srvr = null;

    public Server() throws Exception{
        int x = 0;
    }

    public void connect() throws Exception {
        try {
            ServerSocket srvr = new ServerSocket(5558);
            socketClient = srvr.accept();
            System.out.println("Server: " + "Connection Established");
        } catch (Exception ex) {
            System.err.println(ex + "Client couldn't connect");
        }

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

        reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
    }

    public void receiveFirstMove(Character character) throws Exception {
        /* This Function is only run once to get the server logic running at the beginning of the game */
        character.setName(reader.readLine().trim());
        character.setName(reader.readLine().trim());
        character.setX(Integer.parseInt(reader.readLine().trim()));
        character.setY(Integer.parseInt(reader.readLine().trim()));
        character.setSpeed(Integer.parseInt(reader.readLine().trim()));
        character.setMight(Integer.parseInt(reader.readLine().trim()));
        character.setSanity(Integer.parseInt(reader.readLine().trim()));
        character.setKnowledge(Integer.parseInt(reader.readLine().trim()));
        character.setTraitor(Boolean.parseBoolean(reader.readLine().trim()));

    }

    public void sendMove(Character character) throws IOException {
        int x = character.getX();
        int y = character.getY();
        int speed = character.getSpeed();
        int might = character.getMight();
        int sanity = character.getSanity();
        int knowledge = character.getKnowledge();
        boolean traitor = character.isTraitor();

        writer.write(x+"\r\n'");
        writer.write(y+"\r\n'");
        writer.write(speed+"\r\n'");
        writer.write(might+"\r\n'");
        writer.write(sanity+"\r\n'");
        writer.write(knowledge+"\r\n'");
        writer.write(traitor+"\r\n'");

    }

    private void receiveMove(Character character, GridPane pane) throws IOException {
        character.setX(Integer.parseInt(reader.readLine().trim()));
        character.setY(Integer.parseInt(reader.readLine().trim()));
        character.setSpeed(Integer.parseInt(reader.readLine().trim()));
        character.setMight(Integer.parseInt(reader.readLine().trim()));
        character.setSanity(Integer.parseInt(reader.readLine().trim()));
        character.setKnowledge(Integer.parseInt(reader.readLine().trim()));
        character.setTraitor(Boolean.parseBoolean(reader.readLine().trim()));

    }
}