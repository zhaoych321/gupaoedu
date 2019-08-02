package tomcat;

import java.io.FileInputStream;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import tomcat.http.Request;
import tomcat.http.Response;
import tomcat.http.Servlet;

public class NettyServer {

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
					// 单实例，多线程
					Servlet obj = (Servlet) Class.forName(className).newInstance();
					servletMapping.put(url, obj);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		// 1、加载配置文件，初始化ServeltMapping
		init();

		NioEventLoopGroup workerGroup = new NioEventLoopGroup();
		NioEventLoopGroup bossGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap server = new ServerBootstrap();
			server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {

						@Override
						protected void initChannel(SocketChannel client) throws Exception {
							client.pipeline().addLast(new HttpResponseEncoder());
							client.pipeline().addLast(new HttpRequestDecoder());
							client.pipeline().addLast(new TomcatHandler());
						}

					}).option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture f = server.bind(port).sync();
			System.out.println("Netty Tomcat 已启动，监听的端口是：" + port);
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public class TomcatHandler extends ChannelInboundHandlerAdapter {

		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			if (msg instanceof HttpRequest) {
				HttpRequest httpRequest = HttpRequest.class.cast(msg);

				// 转交给我们自己的request实现
				Request request = new Request(ctx, httpRequest);
				// 转交给我们自己的response实现
				Response response = new Response(ctx, httpRequest);
				// 实际业务处理
				String url = request.getUrl();

				if (servletMapping.containsKey(url)) {
					servletMapping.get(url).service(request, response);
				} else {
					response.write("404 - Not Found");
				}
			}
		}

	}

	public static void main(String[] args) {
		new NettyServer().start();
	}
}
