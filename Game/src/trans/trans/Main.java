package trans.trans;

public class Main {
	public static void main(String[] args) {
		int state = 262144;
		int num = (state & 0xf0000);
		int reason = num >>> 16;
		System.out.println("link reason : " + reason);
		
	}
}
