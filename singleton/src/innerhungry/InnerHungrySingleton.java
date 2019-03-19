package innerhungry;


public class InnerHungrySingleton {

    private InnerHungrySingleton() {}

    private static final InnerHungrySingleton instance = InnerClass._instance;

    public static InnerHungrySingleton getInstance() {
        return instance;
    }

    private  static class InnerClass {
        private  static final InnerHungrySingleton _instance = new InnerHungrySingleton();
    }

}
