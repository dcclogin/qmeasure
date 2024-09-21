package parallax.bool;

public class T0 extends Bool0 {
    public boolean isTrue() {
        return true;
    }

    @Override
    public Bool0 negate() {
        return new F0();
    }
}
