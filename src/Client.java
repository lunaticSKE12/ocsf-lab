import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;

/**
 * Client is class that connects to server and send information to server.
 * @author Napong Dungduangsasitorn
 *
 */
public class Client extends ObservableClient{
	
	/**
	 * Client method is constructor method.
	 * @param host is address of server.
	 * @param port is port of server.
	 */
	public Client(String host, int port) {
		super(host, port);
	}
	
	/**
	 * handleMessageFromServer is for print message from server.
	 */
	public void handleMessageFromServer(Object message) {
		System.out.println("Message: " + message);
	}
	
	/**
	 * main method is for run Client class.
	 *  
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Client client = new Client("198.162.1.2", 5001);
		while(client.isConnected()) {
			String message = scanner.nextLine();
			if(message.equalsIgnoreCase("quit")) {
				client.closeConnection();
			} else{
				client.sendToServer(message);
			}
		}
	}


}