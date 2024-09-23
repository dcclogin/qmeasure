package exchange.values.natural;

import exchange.values.Value;
import org.jetbrains.annotations.NotNull;

public class Zero implements Nat {

    private final int n;

    public Zero() {
        this.n = 0;
    }

    @Override
    public boolean isZero() {
        return true;
    }

    @Override
    public Nat sub1() {
        throw new Error("undefined");
    }

    @Override
    public int toInteger() {
        return n;
    }

    @Override
    public int comparedTo(Nat o) {
        if (o instanceof Zero) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Nat[0]";
    }

    @Override
    public Nat inverse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInverse(Value a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
