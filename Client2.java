package Q5;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9007);

            InetAddress clientAddress = socket.getLocalAddress();
            int clientPort = socket.getLocalPort();
            InetAddress serverAddress = socket.getInetAddress();
            int serverPort = socket.getPort();

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Scanner scan = new Scanner(System.in);
            System.out.print("Entrez la chaine 1 : ");
            String chaine1 = scan.nextLine();
            System.out.print("Entrez la chaine 2 : ");
            String chaine2 = scan.nextLine();

            System.out.println("Adresse du client : " + clientAddress + " (port " + clientPort + ")");
            System.out.println("Adresse du serveur : " + serverAddress + " (port " + serverPort + ")");
            System.out.println("Chaîne 1 envoyée : " + chaine1);
            System.out.println("Chaîne 2 envoyée : " + chaine2);

            out.writeUTF(chaine1);
            out.writeUTF(chaine2);

            boolean resultat = in.readBoolean();
            System.out.println("Résultat : " + resultat);
            
            int nbclient = in.readInt();
            System.out.println("Le nembre des clients connectés :"+nbclient);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}