package kerwin.design.factory;

public class AwsPay implements ImplPay {
    @Override
    public void pay() {
        System.out.println("亚马逊支付！");
    }
}
