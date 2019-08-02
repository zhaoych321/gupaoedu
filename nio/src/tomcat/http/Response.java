package tomcat.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class Response {

	private ChannelHandlerContext ctx;
//	private HttpRequest req;

	public Response(ChannelHandlerContext ctx, HttpRequest req) {
		this.ctx = ctx;
//		this.req = req;
	}

	public void write(String s) {

		if (s == null || s.length() == 0) {
			return;
		}
		try {
			FullHttpResponse response = new DefaultFullHttpResponse(
					HttpVersion.HTTP_1_1, 
					HttpResponseStatus.OK,
					Unpooled.wrappedBuffer(s.getBytes("UTF-8")));
			response.headers().set("Content-Type", "text/html;");
			ctx.write(response);
			ctx.flush();
			ctx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
