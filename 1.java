package réseaux; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9002);
            System.out.println("En attente de connexion...");

            Socket socket = server.accept();

            InetAddress clientAddress = socket.getInetAddress();
            int clientPort = socket.getPort();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            String chaine1 = in.readUTF();
            String chaine2 = in.readUTF();

            System.out.println("Adresse du client : " + clientAddress + " (port " + clientPort + ")");
            System.out.println("Chaîne 1 reçue : " + chaine1);
            System.out.println("Chaîne 2 reçue : " + chaine2);

            boolean resultat = chaine1.contains(chaine2);
            out.writeBoolean(resultat);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

