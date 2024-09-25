package exchange.values.rational;

import exchange.values.Value;

public class PosQId implements PosQ {

    public PosQId() {}

    @Override
    public PosQ inverse() {
        return new PosQId();
    }

    @Override
    public boolean isId() {
        return true;
    }

    @Override
    public boolean isInverse(Value a) {
        if (a instanceof PosQId) {
            return true;
        }
        return false;
    }

    @Override
    public PosQ compose(Value a) {
        return (PosQ) a;
    }
}
