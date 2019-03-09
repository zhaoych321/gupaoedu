package vip.gupao.homework.factory.abstractfactory;

public class UnityVideo implements IVideo {
    @Override
    public IVideo createVideo() {
        System.out.println("生产unity课程语音课件！");
        return new UnityVideo();
    }
}
