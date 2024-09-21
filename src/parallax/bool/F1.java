package parallax.bool;

public class F1 extends Bool1 {
    public boolean isTrue() {
        return false;
    }

    @Override
    public Bool1 negate() {
        return new T1();
    }
}
