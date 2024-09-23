package exchange.values;

public interface Value {
    Value inverse();
    boolean isInverse(Value a);

}
