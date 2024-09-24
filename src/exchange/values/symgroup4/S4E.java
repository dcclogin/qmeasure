package exchange.values.symgroup4;

import exchange.values.Value;

public class S4E implements S4 {

    private final int[] es;

    public S4E(int[] es) {
        assert (es.length == 4);
        this.es = es;
    }

    public int[] getEs() {
        return es;
    }

    @Override
    public boolean isId() {
        return (es[0] == 0) && (es[1] == 1) && (es[2] == 2) && (es[3] == 3);
    }

    @Override
    public boolean isInverse(Value e) {
        return ((S4) e).compose(this).isId() && this.compose((S4) e).isId();
    }

    @Override
    public S4 square() {
        int[] new_es = new int[es.length];
        for (int i = 0; i < es.length; i++) {
            new_es[i] = es[es[i]];
        }
        return new S4E(new_es);
    }

    @Override
    public S4 cubic() {
        int[] new_es = new int[es.length];
        for (int i = 0; i < es.length; i++) {
            new_es[i] = es[es[es[i]]];
        }
        return new S4E(new_es);
    }

    @Override
    public S4 sqrt() {
        // create ad hoc commodity during computation?
        throw new UnsupportedOperationException();
    }

    @Override
    public S4 inverse() {
        int[] new_es = new int[es.length];
        for (int i = 1; i < es.length; i++) {
            new_es[es[i]] = i;
        }
        return new S4E(new_es);
    }

    @Override
    public S4 compose(S4 a) {
        int[] new_es = new int[es.length];
        for (int i = 0; i < es.length; i++) {
            new_es[i] = es[a.getEs()[i]];
        }
        return new S4E(new_es);
    }

    @Override
    public String toString() {
        return "(" + es[0] + " " + es[1] + " " + es[2] + " " + es[3] + ")";
    }
}
