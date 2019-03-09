package vip.gupao.homework.factory.samplefactory;

import vip.gupao.homework.factory.ICourse;
import vip.gupao.homework.factory.UnityCourse;

public class SampleFactoryTest {
    public static void main(String[] args) {

        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.createCourse(UnityCourse.class);
        course.record();
    }
}
