package staticproxy;

public class StaticProxyTest {

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
