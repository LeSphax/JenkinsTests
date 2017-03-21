import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Leonardo on 2017-03-21.
 */
public class KnockKnockClient {
    public static void main(String[] args) throws IOException {

        Socket kkSocket = new Socket("localhost", 4444);
        PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

        String fromServer;
        String fromUser;
        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if (fromServer.equals("Bye."))
                break;

            DataInputStream stdIn = new DataInputStream(System.in);
            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
        }
    }
}
