package kerwin.design.factory;

public class AwsPayFactory implements ImplPayFactory {
    @Override
    public ImplPay create() {
        return new AwsPay();
    }
}
