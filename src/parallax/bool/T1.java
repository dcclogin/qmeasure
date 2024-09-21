package parallax.bool;

public class T1 extends Bool1 {
    public boolean isTrue() {
        return true;
    }

    @Override
    public Bool1 negate() {
        return new F1();
    }
}
