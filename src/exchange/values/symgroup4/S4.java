package exchange.values.symgroup4;

import exchange.values.Compositional;
import exchange.values.Value;

public interface S4 extends Value {
    S4 square();
    S4 cubic();
    S4 sqrt();
    S4 inverse();
    S4 compose(Value a);
    int[] getEs();
    boolean isId();
    boolean isInverse(Value a);
}
