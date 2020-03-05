package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Server {
	private static Logger logger = Logger.getLogger(Server.class);
	 
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress(10000));
		logger.debug(serverSocket);
		logger.debug("Server startup at 10000");
		while (true) {
			Socket socket = serverSocket.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
 
			while (true) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					String line = reader.readLine();
					logger.debug(line);
					out.write((line + "\r\n").getBytes());
				} catch (Exception e) {
					break;
				}
			}
		}
	}
}
