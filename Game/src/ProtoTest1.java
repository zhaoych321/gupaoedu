import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProtoTest1 {
	private static byte[] intToBytes(int value)
	  {
	    byte[] src = new byte[4];
	    src[3] = (byte)(value >> 24 & 0xFF);
	    src[2] = (byte)(value >> 16 & 0xFF);
	    src[1] = (byte)(value >> 8 & 0xFF);
	    src[0] = (byte)(value & 0xFF);
	    return src;
	  }

	  private static byte[] createData(int num) {
	    ChatOuterClass.Chat.Builder chat_obj = ChatOuterClass.Chat.newBuilder();
	    ChatOuterClass.ChatUser.Builder from_obj = ChatOuterClass.ChatUser.newBuilder();
	    from_obj.setLevel(123);
	    from_obj.setPlayerId(num);
	    from_obj.setUserId(123L);
	    from_obj.setNickname("312");
	    from_obj.setLevel(3);
	    from_obj.setPower(33L);
	    chat_obj.setFrom(from_obj);
	    chat_obj.setContent("请问分公司为发送" + num);
	    chat_obj.setZoneId(2);
	    chat_obj.setIp("192.168.128.253");
	    ChatOuterClass.Chat chat = chat_obj.build();
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    try {
	      chat.writeTo(output);
	    }
	    catch (Exception localException)
	    {
	    }
	    byte[] byteArray = output.toByteArray();
	    return byteArray;
	  }

	  public static void main(String[] args)
	    throws IOException
	  {
	    Socket client = new Socket("180.76.165.218", 10001);
	    client.setSoTimeout(20000);
	    long startTime = System.currentTimeMillis();

	    for (int i = 0; i <= 1; ++i) {
	      byte[] HEAD = { 10, 25 };

	      byte[] data = { 26, 13, 8, 9, 16, 123, 26, 3, 51, 49, 50, 32, 3, 48, 33, 42, 25, -24, -81, -73, -23, -105, -82, -27, -120, -122, -27, -123, -84, -27, -113, -72, -28, -72, -70, -27, -113, -111, -23, -128, -127, 57, 48, 2, 66, 15, 49, 57, 50, 46, 49, 54, 56, 46, 49, 50, 56, 46, 50, 53, 51 };
	      byte[] length = intToBytes(data.length);

	      client.getOutputStream().write(HEAD);
	      client.getOutputStream().write(length);
	      client.getOutputStream().write(data);
	    }

	    long endTime = System.currentTimeMillis();
	    System.out.println("程序运行时间： " + ((endTime - startTime) / 1000L) + "s");
	    if (client != null)
	    {
	      client.close();
	    }
	  }
}
