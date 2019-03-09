package vip.gupao.homework.factory.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new UnityCourseFactory();
        courseFactory.createCourse().record();
        courseFactory.createNote().createNote();
        courseFactory.createVideo().createVideo();
    }
}
