package exchange.values.natural;

public class NOperators {
    public static Nat makeNat(int n) {
        if (n <= 0) {
            return new Zero();
        } else {
            return new Succ(makeNat(n - 1));
        }
    }

    public static Nat plusNat(Nat a, Nat b) {
        if (a.isZero()) {
            return b;
        } else {
            return new Succ(plusNat(a.sub1(), b));
        }
    }

    public static Nat multNat(Nat a, Nat b) {
        if (a.isZero()) {
            return new Zero();
        } else {
            return plusNat(b, multNat(a.sub1(), b));
        }
    }

    public static Nat factNat(Nat a) {
        if (a.isZero()) {
            return makeNat(1);
        } else {
            return multNat(a, factNat(a.sub1()));
        }
    }
}
