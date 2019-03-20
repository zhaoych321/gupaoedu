package simple;

public class Client {

    public ConcretePrototypeA startClone(Prototype concretePrototype) {
        return (ConcretePrototypeA)concretePrototype.clone();
    }
}
