package thread;

public class Player implements Runnable {

	private final int id;
	private Game game;
	
	public Player(int id, Game game) {
		this.id = id;
		this.game = game;
	}

	public String toString() {
		return "Athlete<" + id + ">";
	}
	
	public int hashCode() {
		return new Integer(id).hashCode();
	}
	
	public void playGame() throws InterruptedException {
		System.out.println(this.toString() + "ready!");
		game.play(this);
	}
	
	@Override
	public void run() {
		try {
			playGame();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
