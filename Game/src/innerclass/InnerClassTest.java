package innerclass;

public class InnerClassTest {
	public static long roleId;
	public static class InnerClass {
		
		static {
			System.out.println("��̬���뱻ִ��");
		}
		
		public static long getRoleId() {
			return roleId;
		}
	}
	
	public static void main(String[] args) {
		new InnerClass();
		new InnerClassTest();
		System.out.println(roleId);
	}
}
