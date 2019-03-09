package vip.gupao.homework.factory.abstractfactory;

public class UnityNot implements INote {
    @Override
    public INote createNote() {
        System.out.println("生产unity课程笔记课件！");
        return new UnityNot();
    }
}
