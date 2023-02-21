package Q2;


import java.net.*;
import java.io.*;


public class serveurtp1 {
	
	public static void main(String argv[]) {
		int port = 9003;

		try {

	

		ServerSocket ss = new ServerSocket(port);

		

		System.out.println("Serveur en attente: ");

		Socket soc = ss.accept();

		

		PrintWriter ostream = new PrintWriter (soc.getOutputStream ());


		

		InputStreamReader reader = new InputStreamReader(soc.getInputStream());

		BufferedReader istream = new BufferedReader(reader);

		
		String ch1 = istream.readLine();
		String ch2 = istream.readLine();

		System.out.println("Les chaines recues sont : "+ch1+" et "+ch2);
		
		if(ch1.contains(ch2)) {
			ostream.println(ch1+" contient "+ch2);
			ostream.flush ();
		}
		else {
			ostream.println(ch1+" ne contient pas "+ch2);
			ostream.flush ();
		}
		
		

	

		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}
}