package kerwin.design.factory;

public class AliPay implements ImplPay {
    @Override
    public void pay() {
        System.out.println("阿里支付！");
    }
}
