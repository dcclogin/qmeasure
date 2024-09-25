package exchange.values.cycgroup2;

import exchange.values.Compositional;
import exchange.values.Value;

public interface Z2 extends Value {
    Z2 square();
    Z2 inverse();
    Z2 compose(Value a);
    boolean isId();
    boolean isInverse(Value a);

}
