package pattern.decorator.finery;

public class Main {
	public static void main(String[] args) {
		Person xc = new Person("小菜");
		
		System.out.println("\n 第一种装扮：");
		
		BigTrouser kk = new BigTrouser();
		TShirts dtx = new TShirts();
		
		kk.Decorate(xc);
		dtx.Decorate(kk);
		dtx.show();
		
	}
}
