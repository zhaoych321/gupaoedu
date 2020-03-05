package socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Client {
	private static Logger logger = Logger.getLogger(Client.class);
	public static void main(String[] args) throws Exception {
		// 是否分开写head和body
		boolean writeSplit = false;
		String host = "localhost";
		logger.debug("WriteSplit:" + writeSplit);
 
		Socket socket = new Socket();
		socket.setTcpNoDelay(true);
		socket.connect(new InetSocketAddress(host, 10000));
 
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
 
		String head = "hello ";
		String body = "world\r\n";
		for (int i = 0; i < 10; i++) {
			long label = System.currentTimeMillis();
			if (writeSplit) {
				out.write(head.getBytes());
				out.write(body.getBytes());
			} else {
				out.write((head + body).getBytes());
			}
			String line = reader.readLine();
			System.out.println("RTT:" + (System.currentTimeMillis() - label) + ", receive: " + line);
		}
		in.close();
		out.close();
		socket.close();
	}
}
