package jvm;

public class VolTest {
	private static volatile boolean stop = false;
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(()->{
			int i = 0;
			while(!stop) {
				i ++;
			}
		}).start();
		Thread.sleep(1000);
		stop = true;
	}
}
