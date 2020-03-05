package tomcat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import tomcat.http.Request;
import tomcat.http.Response;
import tomcat.http.Servlet;

public class BIOTomcat {

	private Map<String, Servlet> servletMapping = new HashMap<String, Servlet>();
	private Properties webxml = new Properties();
	ServerSocket server = null;
	int port = 8080;
	
	public void init() {
		try {
			String WEB_INFO = this.getClass().getResource("/").getPath();
			FileInputStream fs = new FileInputStream(WEB_INFO + "web.properties");

			webxml.load(fs);

			for (Object k : webxml.keySet()) {
				String key = k.toString();
				if (key.endsWith(".url")) {
					String servletName = key.replaceAll("\\.url$", "");
					String url = webxml.getProperty(key);
					String className = webxml.getProperty(servletName + ".classname");
					// ��ʵ�������߳�
					Servlet obj = (Servlet) Class.forName(className).newInstance();
					servletMapping.put(url, obj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		// 1�����������ļ�����ʼ��ServeltMapping
		init();

		try {
			server = new ServerSocket(this.port);

			System.out.println("GP Tomcat �������������Ķ˿��ǣ�" + this.port);

			// 2���ȴ��û�����,��һ����ѭ�����ȴ��û�����
			while (true) {
				Socket client = server.accept();
				// 4��HTTP���󣬷��͵����ݾ����ַ������й��ɵ��ַ�����HTTPЭ�飩
				process(client);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void process(Socket client) {
		try {
			
			InputStream is = client.getInputStream();
			OutputStream os = client.getOutputStream();
			
			// 7��Request(InputStrean)/Response(OutputStrean)
			Request request = new Request(is);
			Response response = new Response(os);
			
			// 5����Э���������õ�URL������Ӧ��Servlet�÷������ʵ����
			String url = request.getUrl();
			
			if (servletMapping.containsKey(url)) {
				// 6������ʵ���������service()������ִ�о�����߼�doGet/doPost����
				servletMapping.get(url).service(request, response);
			} else {
				response.write("404 - Not Found");
			}
			
			os.flush();
			os.close();
			
			is.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new BIOTomcat().start();
	}

}
