package exchange.values;

import exchange.values.symgroup4.S4;

public interface Value {
    Value inverse();
    boolean isInverse(Value a);

}
