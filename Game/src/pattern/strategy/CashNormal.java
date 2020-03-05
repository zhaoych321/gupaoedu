package pattern.strategy;

public class CashNormal extends CashSuper {

	@Override
	public double acceptCash(double money) {
		return 0;
	}
}
