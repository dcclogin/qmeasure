package parallax;

import parallax.bool.Bool0;
import parallax.bool.F0;
import parallax.bool.T0;

public class Bit0 extends Bit {
    private final Bool0 True;
    private final Bool0 False;
    public Bool0 state;

    public Bit0() {
        True = new T0();
        False = new F0();
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
