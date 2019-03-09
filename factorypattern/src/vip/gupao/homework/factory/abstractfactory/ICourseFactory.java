package vip.gupao.homework.factory.abstractfactory;

import vip.gupao.homework.factory.ICourse;

public interface ICourseFactory {

    ICourse createCourse();

    IVideo createVideo();

    INote createNote();
}
