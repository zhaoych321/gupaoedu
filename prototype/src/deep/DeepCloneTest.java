package deep;

public class DeepCloneTest {
    public static void main(String[] args) {

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            QiTianDaSheng deepClone = (QiTianDaSheng)qiTianDaSheng.clone();
            boolean bDeepClone = qiTianDaSheng.jinGuBang == deepClone.jinGuBang;
            System.out.println("deep clone：" + bDeepClone);
        } catch (Exception e) {
            e.printStackTrace();
        }

        QiTianDaSheng shallowClone = qiTianDaSheng.shallowClone(qiTianDaSheng);
        boolean bShallowClone = qiTianDaSheng.jinGuBang == shallowClone.jinGuBang;
        System.out.println("shallow clone：" + bShallowClone);
    }
}
