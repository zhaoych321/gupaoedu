package pattern.simlefactory;

public class OperationSub extends Operation {

	@Override
	public double getResult() {
		return get_numberA() - get_numberB();
	}
}
