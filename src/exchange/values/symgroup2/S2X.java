package exchange.values.symgroup2;

import exchange.values.Value;

public class S2X implements S2{
    @Override
    public S2 square() {
        return new S2Id();
    }

    @Override
    public S2 inverse() {
        return new S2X();
    }

    @Override
    public boolean isId() {
        return false;
    }

    @Override
    public boolean isInverse(Value a) {
        return (a instanceof S2X);
    }

    @Override
    public S2 compose(Value a) {
        if (a instanceof S2Id) {
            return this;
        } else {
            return new S2Id();
        }
    }

    @Override
    public String toString() {
        return "not";
    }
}
