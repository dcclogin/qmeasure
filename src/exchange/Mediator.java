package exchange;

import exchange.values.Value;
import exchange.values.symgroup2.S2;
import exchange.values.symgroup4.S4;

import java.util.Random;

// attempt to incorporate object a into the commodity exchange framework
// can mediator just be another commodity?
// how to account for the "emergence" of money / master-signifier?
public class Mediator {

    private Value a;
    private Value b;

    public Mediator(Value a, Value b) {
        this.a = a;
        this.b = b;
    }

    public Value get_a() {
        return a;
    }
    public Value get_b() {
        return b;
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
        if (b instanceof S2 && a instanceof S2) {
            a = Transcendental.contingentValS2();
            b = a.inverse();
        }
    }
    private void antagonistic() {}

    // if antagonistic return false
    // currently just random
    public boolean mediate() {
        if (isInverse(a, b)) { return true; }
        Random r = new Random();
        int i = r.nextInt(4);
        return switch (i) {
            case 0 -> { antagonistic(); yield false; }
            case 1 -> { compromise_a(); yield true; }
            case 2 -> { compromise_b(); yield true; }
            case 3 -> { compromise_both(); yield true; }
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }


}
