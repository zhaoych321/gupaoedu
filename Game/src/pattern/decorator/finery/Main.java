package pattern.decorator.finery;

public class Main {
	public static void main(String[] args) {
		Person xc = new Person("С��");
		
		System.out.println("\n ��һ��װ�磺");
		
		BigTrouser kk = new BigTrouser();
		TShirts dtx = new TShirts();
		
		kk.Decorate(xc);
		dtx.Decorate(kk);
		dtx.show();
		
	}
}
