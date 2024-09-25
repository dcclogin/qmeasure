package exchange.values.natural;

import exchange.values.Value;

public class Succ implements Nat {

    private final Nat val;
    private final int n;

    public Succ(Nat val) {
        this.val = val;
        this.n = 1 + val.toInteger();
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public Nat sub1() {
        return val;
    }

    @Override
    public int toInteger() {
        return n;
    }

    @Override
    public int comparedTo(Nat o) {
        if (o instanceof Zero) {
            return 1;
        } else {
            return val.comparedTo(o.sub1());
        }
    }

    @Override
    public String toString() {
        return String.format("Nat[%d]", n);
    }

    @Override
    public Nat inverse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Value compose(Value v) {
        return null;
    }

    @Override
    public boolean isInverse(Value a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
