package vip.gupao.homework.factory;

public class UnityCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Unity课程视频！");
    }
}
