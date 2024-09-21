package parallax;

import parallax.bool.Bool1;
import parallax.bool.F1;
import parallax.bool.T1;

public class Bit1 extends Bit {
    private final Bool1 True;
    private final Bool1 False;
    public Bool1 state;

    public Bit1() {
        True = new T1();
        False = new F1();
        state = False;
    }

    public Object getTrue() {
        return True;
    }
    public Object getFalse() {
        return False;
    }
    public void not() {
        state = state.negate();
    }
}
