package exchange.values.symgroup4;

import exchange.values.Value;

public class S4Id implements S4 {

    // cyclic notation: need a circular data structure
    private final int[] es;

    public S4Id() {
        es = new int[4];
        es[0] = 0; es[1] = 1; es[2] = 2; es[3] = 3;
    }

    public int[] getEs() {
        return es;
    }

    @Override
    public boolean isId() {
        return true;
    }

    @Override
    public boolean isInverse(Value e) {
        return ((S4) e).isId();
    }

    @Override
    public S4 square() {
        return this;
    }

    @Override
    public S4 cubic() {
        return this;
    }

    @Override
    public S4 sqrt() {
        throw new UnsupportedOperationException();
    }

    @Override
    public S4 inverse() {
        return this;
    }

    /* id * a = a */
    @Override
    public S4 compose(Value a) {
        return ((S4) a);
    }

    @Override
    public String toString() {
        return "(" + es[0] + " " + es[1] + " " + es[2] + " " + es[3] + ")";
    }
}
