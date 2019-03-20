package simple;

import java.util.ArrayList;

public class PrototypeTest {
    public static void main(String[] args) {

        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(10);
        concretePrototypeA.setName("lebulang");
        concretePrototypeA.setHobbies(new ArrayList());
        System.out.println(concretePrototypeA);

        Client client = new Client();
        ConcretePrototypeA concretePrototypeClone = client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeClone);

        System.out.println("克隆对象中的引用类型地址值：" + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值：" + concretePrototypeA.getHobbies());
        System.out.println("对象地址比较："+(concretePrototypeClone.getHobbies() == concretePrototypeA.getHobbies()));
    }
}
