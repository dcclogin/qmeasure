package exchange.values.rational;

import exchange.values.Value;
import exchange.values.natural.Nat;

public class PosQE implements PosQ {

    private final Nat numerator;
    private final Nat denominator;

    public PosQE(Nat m, Nat n) {
        if (n.isZero()) {
            throw new Error("denominator should not be zero");
        }
        this.numerator = m;
        this.denominator = n;
    }

    public Nat getNumerator() {
        return numerator;
    }
    public Nat getDenominator() {
        return denominator;
    }

    @Override
    public PosQ inverse() {
        return new PosQE(denominator, numerator);
    }

    @Override
    public boolean isId() {
        return (numerator.comparedTo(denominator) == 0);
    }

    @Override
    public boolean isInverse(Value a) {
        return false;
    }

    @Override
    public PosQ compose(Value a) {
        return null;
    }
}
