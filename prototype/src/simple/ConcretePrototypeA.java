package simple;

import java.util.List;

public class ConcretePrototypeA implements Prototype {

    private int age;
    private String name;
    private List hobbies;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.getAge());
        concretePrototypeA.setName(this.getName());
        concretePrototypeA.setHobbies(this.getHobbies());
        return concretePrototypeA;
    }
}
