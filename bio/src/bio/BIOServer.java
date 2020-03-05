package bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
	
	private final static int port = 80;
	
	public void listen(){
		ServerSocket serverSocket = null;
		System.out.println("服务器启动 ！ 端口：" + port);
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket client = serverSocket.accept();
				new ServerHandler(client).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class ServerHandler extends Thread {
		public Socket client;

		public ServerHandler(Socket client) {
			super();
			this.client = client;
		}

		@Override
		public void run() {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = client.getInputStream();
				
				byte[] b = new byte[1024];
				int len;
				if ((len = is.read(b)) < 0) {
					throw new IOException();
				}
				
				String content = new String(b, 0, len);
				System.out.println("收到客户端数据 ：" + content);
				
				os = client.getOutputStream();
				StringBuilder sb = new StringBuilder();
				sb.append("服务器返回数据：");
				sb.append(content);
				os.write(sb.toString().getBytes());
				os.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (is != null) {
						is.close();
					}
					if (os != null) {
						os.close();
					}
					if (client != null) {
						client.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new BIOServer().listen();
	}
}
