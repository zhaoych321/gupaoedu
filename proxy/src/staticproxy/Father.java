package staticproxy;

public class Father implements Person {

    private Person son;
    public Father(Person son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        before();
        son.findLove();
        after();
    }

    private void before() {
        System.out.println("开始物色！");
    }

    private void after() {
        System.out.println("符合条件！");
    }
}
