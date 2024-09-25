package exchange.values.lattice4;

import exchange.values.Value;

import java.util.Optional;
import java.util.Random;

public class L4Top implements L4 {

    public Optional<Integer> compareTo(L4 o) {
        if (o instanceof L4Top) {
            return Optional.of(0);
        } else if (o instanceof L4L || o instanceof L4R) {
            return Optional.of(1);
        } else {
            return Optional.of(2);
        }
    }

    public L4 upper() {
        return this;
    }

    public L4 lower() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return new L4L();
        } else {
            return new L4R();
        }
    }

    public L4 negate() {
        return new L4Bot();
    }

    public L4 compose(Value v) {
        return null;
    }

    @Override
    public String toString() {
        return "top";
    }

    @Override
    public Value inverse() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isInverse(Value a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
