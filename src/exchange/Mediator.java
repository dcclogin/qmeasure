package exchange;

import exchange.values.Value;
import exchange.values.symgroup4.S4;

// attempt to incorporate objet a into the commodity exchange framework???
public class Mediator {

    private Value a;
    private Value b;

    public Mediator(Value a, Value b) {
        this.a = a;
        this.b = b;
    }

    private boolean isInverse(Value a, Value b) {
        return a.isInverse(b) && b.isInverse(a);
    }

    private void compromise_b() {
        b = a.inverse();
    }
    private void compromise_a() {
        a = b.inverse();
    }
    private void compromise_both() {
        if (a instanceof S4 && b instanceof S4) {
            a = Transcendental.contingentValS4();
            b = a.inverse();
        }
    }
    private void antagonistic() {}

    public Value get_a() {
        return a;
    }
    public Value get_b() {
        return b;
    }
}
