package exchange.values.rational;

import exchange.values.Compositional;
import exchange.values.Value;

public interface PosQ extends Value {
    PosQ inverse();
    PosQ compose(Value a);
    boolean isId();
    boolean isInverse(Value a);
}
