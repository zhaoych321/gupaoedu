package kerwin.design.factory;

public class AliPayFactory implements ImplPayFactory {
    @Override
    public ImplPay create() {
        return new AliPay();
    }
}
