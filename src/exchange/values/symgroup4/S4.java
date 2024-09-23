package exchange.values.symgroup4;

import exchange.values.Compositional;
import exchange.values.Value;

public interface S4 extends Value, Compositional<S4> {
    S4 square();
    S4 cubic();
    S4 sqrt();
    S4 inverse();
    int[] getEs();
    boolean isId();
    // boolean isInverse(S4 a)
    boolean isInverse(Value a);
}
