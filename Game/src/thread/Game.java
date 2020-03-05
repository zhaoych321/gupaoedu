package thread;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game implements Runnable {

	private boolean start = false;
	
	@Override
	public void run() {
		start = false;
		System.out.println("Ready......");
		System.out.println("Ready......");
		System.out.println("game start");
		beginStart();
	}

	public void play(Player player) throws InterruptedException {
		synchronized (this) {
			while(!start) {
				wait();
			}
			
			if(start) {
				System.out.println(player + " have played!");
				notify();
			}
			
		}
	}
	
	public synchronized void beginStart() {
		start = true;
		notify();
	}

	public static void main(String[] args) throws InterruptedException {
		Set<Player> players = new HashSet<>();
		
		Game game = new Game();
		
		for (int i = 0; i < 3; i++) {
			players.add(new Player(i+1, game));
		}
		
		Iterator<Player> it = players.iterator();
		while(it.hasNext()) {
			new Thread(it.next()).start();
		}
		
		Thread.sleep(100);
		
		new Thread(game).start();
	}
}
