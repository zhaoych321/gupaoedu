package pattern.simlefactory;

public class OperationFactory {
	public static Operation createOperation(String operation) {
		Operation op = null;
		switch (operation) {
		case "+":
			op = new OperationAdd();
			break;
		case "-":
			op = new OperationSub();
			break;
		case "*":
			op = new OperationMul();
		case "/":
			op = new OperationDiv();
			break;
		default:
			break;
		}
		return op;
	}
	
	public static void main(String[] args) {
		Operation oper;
		oper = OperationFactory.createOperation("+");
		oper.set_numberA(10);
		oper.set_numberB(2);
		System.out.println("+ = " + oper.getResult());
	}
}
