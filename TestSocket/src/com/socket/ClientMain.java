package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.bouncycastle.util.encoders.Base64;



public class ClientMain {
	
	private final static int sendtimes = 1; //发送次数

	  class SendThread extends Thread{  
	        private Socket socket;  
	        private int i;
	        public SendThread(Socket socket, int i) {  
	            this.socket = socket;  
	            this.i = i;
	        }  
	        @Override  
	        public void run() {  
	        	     	
				try{
//					String outputXmlStr = "<cmd_command cmd_data=\"SetCreateRole\" serverid=\"7250\" status=\"true\"/>";
//					String outputXmlStr = "<cmd_command cmd_data=\"SetChannelChat\" serverid=\"7250\" status=\"false\"/>";
//					String outputXmlStr = "<cmd_command cmd_data=\"GetCreateRole\" serverid=\"7250\"/>";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"GetChannelChat\" serverid=\"7250\"/>";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"AddForbidLogin\" roleid=\"4097\"  forbidtime=\"100\"  desc= \"后视镜看好\"/>";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"DelForbidLogin\" roleid=\"4097\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetRoleForbidLogin\" roleid=\"40961\"/>";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"AddForbidTalk\" roleid=\"4097\"  forbidtime=\"-1\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"DelForbidTalk\" roleid=\"12289\"/>";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"GetRoleForbidTalk\" roleid=\"12289\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetAccID\" roleid=\"90113\" rolename=\"\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"KickRole\" roleid=\"12289\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetAccCharList\" accid=\"19026\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetChar\" roleid=\"\" rolename=\"仉亦南\" />";
//		        	String outputXmlStr = "<cmd_command cmd_data=\"GetGaeaId\" roleid=\"12289\" />";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetGold\" accid=\"19026\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetMoney\" roleid=\"\" rolename=\"南郭细鑫\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"FactionInfo\" factionid=\"4097\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"SelectBill\" roleid=\"12289\" chargesn=\"12345\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetFreshCardInfo\" freshcard=\"ABCDOUVUDJFN\"/>";
		        	//String outputXmlStr = "<cmd_command cmd_data=\"GetSnStringInfo\" snstring=\"gtdj61\"/>";
					//String outputXmlStr = "<cmd_command cmd_data=\"StartLink\"/>";
					//String outputXmlStr = "<cmd_command cmd_data=\"Gm\" content=\"addcharge 4097 100005 2 2 10 4\"/>";
					
//					String content = "凯爷&吊炸天\n大家注意了呀，凯爷被降至<color=\"#794d00\">1</color>级，获得<color=\"#794d00\">100000000000</color>补偿帮派资金。";
//		        	String mailcontent = new String(Base64.encode(content.getBytes("UTF-8")));
//					String outputXmlStr = "<cmd_command cmd_data=\"SystemMail\" roleids=\"4097\" sendplayer=\"仙剑研发组\" mailcontent=\""+mailcontent+"\" item=\"\" money=\"0\" stone=\"0\" yuanbao=\"0\" sendtitle=\"发福&利了!\" />";
				
//					String outputXmlStr = "<cmd_command cmd_data=\"SelectBill\" roleid=\"12289\"  chargesn=\"586225544450\"/>";
//					String outputXmlStr = "<cmd_command cmd_data=\"SelectAllBill\" roleid=\"12289\"/>";
					
//					String content = "<color=#ffff33ff>今天好冷呀</color>天气不好呀<color=#f66633ff>明天坏天气</color>";
//		        	content = new String(Base64.encode(content.getBytes("UTF-8")));
//		        	String outputXmlStr =" <cmd_command cmd_data=\"Bull\" text=\""+content+"\" />";
		        	
					//String content = "第" + i + "封邮件!";
//					String content = "GMT测试邮件1";
//		        	String mailcontent = new String(Base64.encode(content.getBytes("UTF-8")));
//					String outputXmlStr = "<cmd_command cmd_data=\"FullServiceMail\" sendtitle=\""+content+"\" starttime=\"2016-10-24 18:20:00\" endtime=\"2018-02-24 19:00:00\" sendplayer=\"仙剑研发组\" mailcontent=\""+mailcontent+"\" item=\"\" bindyuanbao=\"0\" money=\"1000\" stone=\"0\" yuanbao=\"13000\"/>";
//					String outputXmlStr = "<cmd_command cmd_data=\"ChangeRoleName\" roleid=\""+155728+"\" rolename=\"无情无痕\"/>";
//					String outputXmlStr = "<cmd_command cmd_data=\"ChangeFactionName\" roleid=\""+155728+"\" factionname=\"无情2\"/>";
					String outputXmlStr = "<cmd_command cmd_data=\"Gm\"  content=\"tt 49182675\"/>";
					DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
					
					byte[] outputXmlBytesArr = outputXmlStr.getBytes("UTF-8");
					int v = outputXmlBytesArr.length;
					byte[] lengthbytearr = intToBytes(v, true);
					byte[] resultArr = new byte[lengthbytearr.length+outputXmlBytesArr.length];
					int i = 0;
					while(i<lengthbytearr.length){
						resultArr[i] = lengthbytearr[i];
						i++;
					}
					int j = 0;
					while(j<outputXmlBytesArr.length){
						resultArr[i] = outputXmlBytesArr[j];
						j++;
						i++;
					}
			//			dataoutputstream.write((v >>>  0) & 0xFF);
			//			dataoutputstream.write((v >>>  8) & 0xFF);
			//			dataoutputstream.write((v >>> 16) & 0xFF);
			//			dataoutputstream.write((v >>> 24) & 0xFF);
					
					dataoutputstream.write(resultArr);
					dataoutputstream.flush();
					
					System.out.println("socket send xmlString:"+outputXmlStr);
					
					socket.close(); //关闭Socket
				}catch(Exception e) {
					System.out.println("Error"+e); //出错，则打印出错信
				}
	        }  
	        
	        public byte[] intToBytes(int nNum, boolean byteOrder) {
		        byte[] bytesRet = new byte[4];
		        if(byteOrder) {
			        bytesRet[0] = (byte) ((nNum >> 24) & 0xFF);
			        bytesRet[1] = (byte) ((nNum >> 16) & 0xFF);
			        bytesRet[2] = (byte) ((nNum >> 8) & 0xFF);
			        bytesRet[3] = (byte) (nNum & 0xFF);
		        } else {
			        bytesRet[3] = (byte) ((nNum >> 24) & 0xFF);
			        bytesRet[2] = (byte) ((nNum >> 16) & 0xFF);
			        bytesRet[1] = (byte) ((nNum >> 8) & 0xFF);
			        bytesRet[0] = (byte) (nNum & 0xFF);
		        }
		        return bytesRet;
		    }

	    }  
	  
	    class ReceiveThread extends Thread{  
	        private Socket socket;  
	          
	        public ReceiveThread(Socket socket) {  
	            this.socket = socket;  
	        }  
	  
	        @Override  
	        public void run() {
	        	
	            while(true){ 
	                try {                     
	                	DataInputStream dis = new DataInputStream(socket.getInputStream());
	                	if (dis.available() <= 0) {
							continue;
						}
	        	        int length = dis.readInt();
	        			byte[] byteArrays = new byte[length];
	        			int readNum = dis.read(byteArrays);
	        			if (readNum != length){
	        				System.out.println("read socket stream error.readNum:expectNum "+readNum+":"+length);
//	        				socket.close();
	        				return;
	        			}
	        			String xmlString = new String(byteArrays, "UTF-8");
	        			System.out.println("socket receive xmlString:"+xmlString);
	        			break;
	                } catch (Exception e) {  
	                	System.out.println(e.toString());
	                    e.printStackTrace();  
	                }
//					Thread clientSocket = new ClientSocket(socket);
//					clientSocket.start();
	            }
	        }  
	    }  
	      
	    public void start(int i) throws UnknownHostException, IOException{  
//	    	Socket socket = new Socket("123.59.80.148",24384);  
	    	//Socket socket = new Socket("123.59.84.243",24984);  //运营
	    	//Socket socket = new Socket("123.59.139.216",30034);  //正式服
//	    	Socket socket = new Socket("127.0.0.1",1102);  //本地
	    	//Socket socket = new Socket("192.168.2.175",26434);  //本地
	    	//Socket socket = new Socket("192.168.2.134",26484);  //本地
//	    	Socket socket = new Socket("192.168.64.34",35334);  //分支
	    	Socket socket = new Socket("123.206.96.31",30034);  //分支
//	    	Socket socket = new Socket("127.0.0.1",30034);  //机器人  服务器serverid 999
	        new SendThread(socket, i).start();  
	        new ReceiveThread(socket).start(); 
	    }  
	
	public static void main(String[] args) throws UnknownHostException, IOException {

		for (int i = 0; i < sendtimes; i++) {
			new ClientMain().start(7);  
		}
		
		
//		String outputXmlStr =  "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"+
//				  "<root name=\"root\" cmd_data=\"AddForbidTalk\">"+
//			      	"<name>Alexia</name>"+
//			      	"<age>23</age>"+
//			      	"<sex>Female</sex>"+
//			      "</root>";
//		try{
//			
//			Socket socket=new Socket("127.0.0.1",1100);
//
//			DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
//			
//			byte[] outputXmlBytesArr = outputXmlStr.getBytes("UTF-8");
//			int v = outputXmlBytesArr.length;
//			byte[] lengthbytearr = intToBytes(v, true);
//			byte[] resultArr = new byte[lengthbytearr.length+outputXmlBytesArr.length];
//			int i = 0;
//			while(i<lengthbytearr.length){
//				resultArr[i] = lengthbytearr[i];
//				i++;
//			}
//			int j = 0;
//			while(j<outputXmlBytesArr.length){
//				resultArr[i] = outputXmlBytesArr[j];
//				j++;
//				i++;
//			}
////			dataoutputstream.write((v >>>  0) & 0xFF);
////			dataoutputstream.write((v >>>  8) & 0xFF);
////			dataoutputstream.write((v >>> 16) & 0xFF);
////			dataoutputstream.write((v >>> 24) & 0xFF);
//			dataoutputstream.write(resultArr);
//			dataoutputstream.flush();
//			
//			socket.close(); //关闭Socket
//		}catch(Exception e) {
//			System.out.println("Error"+e); //出错，则打印出错信
//		}
	}
	
}
