import java.io.*;
import java.net.Socket;

public class Client {
    Socket socketClient = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;

    private void connect() throws Exception {
        try {
            socketClient = new Socket("localhost",5558);
            System.out.println("Server: " + "Connection Established");
        } catch (Exception ex) {
            System.err.println(ex + "Client couldn't connect");
        }

        reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
    }

    private void sendMove() throws IOException {
        // Sender
    }

    private void receiveMove() throws IOException {
        // Receiver
    }
}
