package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class GreetingClient {
	public static void main(String[] args) {
		String serverName = "server"/**args[0]**/;
		int port = 1000/*Integer.parseInt(args[1])*/;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
//			Socket client = new Socket(serverName, port);

			Socket client = new Socket();
			client.connect(new InetSocketAddress("127.0.0.1", port), 1000);//设置连接请求超时时间10 s
			client.setSoTimeout(3000);//设置读操作超时时间30 s
			
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
