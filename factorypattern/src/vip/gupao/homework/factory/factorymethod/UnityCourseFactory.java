package vip.gupao.homework.factory.factorymethod;

import vip.gupao.homework.factory.ICourse;
import vip.gupao.homework.factory.UnityCourse;

public class UnityCourseFactory implements ICourseFactory {

    @Override
    public ICourse createCourse() {
        return new UnityCourse();
    }
}
