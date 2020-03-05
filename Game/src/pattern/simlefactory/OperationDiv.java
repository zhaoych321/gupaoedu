package pattern.simlefactory;

public class OperationDiv extends Operation {

	@Override
	public double getResult() {
		if (get_numberB() == 0) {
			new RuntimeException("除数不能为0！");
		}
		return get_numberA() / get_numberB();
	}
}
