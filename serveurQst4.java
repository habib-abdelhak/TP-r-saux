package Q3;

import java.io.DataInputStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serveurQst4 {
	public static void main(String argv[]) {
		int port = 1229;
		try {
		
		ServerSocket ss = new ServerSocket(port);

		while(true) {
			
		System.out.println("Serveur en attente: ");
		
		Socket soc = ss.accept();

		ObjectOutputStream ostream = new ObjectOutputStream (soc.getOutputStream ());

		ObjectInputStream reader = new ObjectInputStream(soc.getInputStream());

		String ch1 = (String) reader.readObject();
		String ch2 = (String) reader.readObject();

		System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
		
		if(ch1.contains(ch2)) {
			ostream.writeObject(ch1+" contient "+ch2);
			ostream.flush ();
		}
		else {
			ostream.writeObject(ch1+" ne contient pas "+ch2);
			ostream.flush ();
		}
		
	
		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );

			}

		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	
}}}