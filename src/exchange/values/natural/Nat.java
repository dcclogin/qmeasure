package exchange.values.natural;

public interface Nat extends NComparable<Nat> {
    boolean isZero();
    Nat sub1();
    int toInteger();
}
