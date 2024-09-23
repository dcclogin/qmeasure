package exchange.values.natural;

import exchange.values.Value;

public interface Nat extends NComparable<Nat>, Value {
    boolean isZero();
    Nat sub1();
    int toInteger();
}
