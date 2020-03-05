package pattern.simlefactory;

public class OperationAdd extends Operation {

	@Override
	public double getResult() {
		return get_numberA() + get_numberB();
	}
}
