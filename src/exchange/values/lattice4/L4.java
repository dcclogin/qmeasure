package exchange.values.lattice4;

import exchange.values.Value;

public interface L4 extends VComparable<L4>, Value {
    L4 upper();
    L4 lower();
    L4 negate();
    L4 compose(Value v);
}
