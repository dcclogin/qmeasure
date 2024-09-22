package exchange.values.natural;

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

    public int comparedTo(Nat o) {
        if (o instanceof Zero) {
            return 0;
        } else {
            return -1;
        }
    }
}
