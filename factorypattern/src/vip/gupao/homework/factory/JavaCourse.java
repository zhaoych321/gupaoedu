package vip.gupao.homework.factory;

public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Java课程视频！");
    }
}
