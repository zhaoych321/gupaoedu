package vip.gupao.homework.factory.factorymethod;

import vip.gupao.homework.factory.ICourse;
import vip.gupao.homework.factory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }
}
