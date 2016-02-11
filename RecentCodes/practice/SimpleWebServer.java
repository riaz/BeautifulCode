package practice;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
	Socket cl;
	
	public void processClient(Socket client){
		//Read from client socket and 
		//Write to client socket
		//This is the handle to handle the communication
	}
	
	public void startServer(int port)	
	{
		try{
			ServerSocket socket = new ServerSocket(port);
			if(socket.isBound()){
				System.out.println("Server listening on port " + port);
			}
			cl = socket.accept();
			processClient(cl);
		}catch(IOException io){
			io.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		new SimpleWebServer().startServer(8010);
	}

}
