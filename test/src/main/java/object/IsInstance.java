package object;


public class IsInstance {
    public static void main(String[] args) {
        try {
            Class<?> s = Class.forName("object.S");
            boolean instance = s.isInstance(new Integer(37));
            System.out.println(instance);
            boolean b2 = s.isInstance(new S());
            System.out.println(b2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
