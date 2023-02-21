package Q5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Thread{
	
	private Socket socket;

     static int nbclient=0;

	public  Serveur(Socket socket)
	{
		this.socket=socket;
	}
	public void run()
	{
		
	try
	{ 
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
    out.writeInt(nbclient);
    out.flush();
    nbclient--;
    socket.close();
	}catch (IOException e) {
        e.printStackTrace();
    }
	}
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9007);
            System.out.println("En attente de connexion...");
            while(true) {
            Socket socket = server.accept();
            Serveur t=new Serveur(socket);

            nbclient++;

            t.start();}
            

           
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}