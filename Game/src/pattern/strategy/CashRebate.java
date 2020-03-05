package pattern.strategy;

public class CashRebate extends CashSuper {
	private double moneyRebate = 1d;
	
	public CashRebate(double moneyRebate) {
		super();
		this.moneyRebate = moneyRebate;
	}

	@Override
	public double acceptCash(double money) {
		return money * moneyRebate;
	}
}
