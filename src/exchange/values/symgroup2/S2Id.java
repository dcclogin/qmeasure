package exchange.values.symgroup2;

import exchange.values.Value;

public class S2Id implements S2 {
    @Override
    public S2 square() {
        return new S2Id();
    }

    @Override
    public S2 inverse() {
        return new S2Id();
    }

    @Override
    public boolean isId() {
        return true;
    }

    @Override
    public boolean isInverse(Value a) {
        return (a instanceof S2Id);
    }

    @Override
    public S2 compose(Value a) {
        return (S2) a;
    }

    @Override
    public String toString() {
        return "id";
    }
}
