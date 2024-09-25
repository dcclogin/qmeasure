package exchange.values.symgroup2;

import exchange.values.Compositional;
import exchange.values.Value;

public interface S2 extends Value {
    S2 square();
    S2 inverse();
    S2 compose(Value a);
    boolean isId();
    boolean isInverse(Value a);
}
