package exchange.values.lattice4;

public interface L4 extends VComparable<L4> {
    L4 upper();
    L4 lower();
    L4 negate();
    L4 compose(L4 v);
}
