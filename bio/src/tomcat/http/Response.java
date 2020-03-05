package tomcat.http;

import java.io.OutputStream;

public class Response {

	OutputStream out;
	public Response(OutputStream os) {
		out = os;
	}

	public void write(String s) {
		try {
			//�õ���HTTPЭ�飬���ҲҪ��ѭHTTPЭ��
			//����һ��״̬�� 200
			StringBuilder sb = new StringBuilder();
			sb.append("HTTP/1.1 200 OK\n")
			.append("Content-Type: text/html;\n")
			.append("\r\n")
			.append(s);
			out.write(sb.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
