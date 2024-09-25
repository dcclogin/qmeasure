package exchange.values;

public interface Value extends Compositional<Value> {
    Value inverse();
    Value compose(Value v);
    boolean isInverse(Value a);
}
