package bio;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient {
	
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			socket = new Socket("localhost", 80);
			
			os = socket.getOutputStream();
			os.write("1234567".getBytes());
			
			
			is = socket.getInputStream();
			
			byte[] buff = new byte[1024];
			int r = 0;
			while ((r = is.read(buff)) < 0 && r != -1) {

			}
			
			String content = new String(buff, 0, r);
			System.out.println("客户端收到数据："+content);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != is) {
					is.close();
				}
				if (null != os) {
					os.close();
				}
				if (null != socket) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
