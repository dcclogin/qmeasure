package exchange.values;

public abstract class Value implements VComparable<Value> {
    abstract Value upper();
    abstract Value lower();
    abstract Value negate();
}
