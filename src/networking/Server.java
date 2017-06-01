package networking;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		final int PORTNO = 9000; // must be > 1024
		ServerSocket server = new ServerSocket(PORTNO);
		System.out.println("Server Start");
		System.out.println("Waiting for the client to join");
		Socket socket = server.accept();
		System.out.println("Welcome client");
		System.out.println("Enter the message send to client");
		Scanner scan = new Scanner(System.in);
		String message = scan.nextLine();
		OutputStream os = socket.getOutputStream();
		os.write(message.getBytes());
		System.out.println("Message Send......");
		os.close();
		scan.close();
		socket.close();
	}

}
