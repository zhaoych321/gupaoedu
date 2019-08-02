package tomcat.servlet;

import tomcat.http.Request;
import tomcat.http.Response;
import tomcat.http.Servlet;

public class SecondServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws Exception {
		doPost(request, response);
	}

	@Override
	public void doPost(Request request, Response response) throws Exception {
		response.write("this is second servlet!");
	}

}
