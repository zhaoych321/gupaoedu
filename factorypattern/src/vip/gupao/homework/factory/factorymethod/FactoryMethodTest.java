package vip.gupao.homework.factory.factorymethod;

import vip.gupao.homework.factory.ICourse;

public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.createCourse();
        course.record();
    }
}
