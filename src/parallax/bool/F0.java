package parallax.bool;

public class F0 extends Bool0 {
    public boolean isTrue() {
        return false;
    }

    @Override
    public Bool0 negate() {
        return new T0();
    }
}
