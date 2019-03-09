package vip.gupao.homework.factory.samplefactory;

import vip.gupao.homework.factory.ICourse;

public class CourseFactory {

    public ICourse createCourse(Class clzz) {
        try {
            if (null != clzz) {
                return (ICourse) clzz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
