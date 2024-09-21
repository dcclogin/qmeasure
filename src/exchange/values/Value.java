package exchange.values;

public interface Value extends VComparable<Value> {
    Value upper();
    Value lower();
    Value negate();
    Value compose(Value v);
}
