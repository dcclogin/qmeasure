package exchange.values.cycgroup2;

import exchange.values.Value;

public class Z2E implements Z2 {
    public Z2E() {}

    @Override
    public Z2 square() {
        return new Z2Id();
    }

    @Override
    public Z2 inverse() {
        return new Z2E();
    }

    @Override
    public boolean isId() {
        return false;
    }

    @Override
    public boolean isInverse(Value a) {
        return ((Z2) a) instanceof Z2E;
    }

    @Override
    public Z2 compose(Value a) {
        if (a instanceof Z2Id) {
            return new Z2E();
        } else {
            return new Z2Id();
        }
    }
}
