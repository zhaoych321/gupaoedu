package pattern.simlefactory;

public class OperationMul extends Operation {

	@Override
	public double getResult() {
		return get_numberA() * get_numberB();
	}
}
