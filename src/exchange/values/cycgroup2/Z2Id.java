package exchange.values.cycgroup2;

import exchange.values.Value;

public class Z2Id implements Z2 {

    public Z2Id() {}

    @Override
    public Z2 compose(Value a) {
        return (Z2) a;
    }

    @Override
    public Z2 square() {
        return new Z2Id();
    }

    @Override
    public Z2 inverse() {
        return new Z2Id();
    }

    @Override
    public boolean isId() {
        return true;
    }

    @Override
    public boolean isInverse(Value a) {
        return ((Z2) a).isId();
    }

    @Override
    public String toString() {
        return "id";
    }
}
