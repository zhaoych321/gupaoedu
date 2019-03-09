package vip.gupao.homework.factory.abstractfactory;

import vip.gupao.homework.factory.ICourse;
import vip.gupao.homework.factory.UnityCourse;

public class UnityCourseFactory implements ICourseFactory {

    @Override
    public ICourse createCourse() {
        return new UnityCourse();
    }

    @Override
    public INote createNote() {
        return new UnityNot();
    }

    @Override
    public IVideo createVideo() {
        return new UnityVideo();
    }
}
