package exchange.values.lattice4;

import java.util.Optional;

public class L4L implements L4 {
    public Optional<Integer> compareTo(L4 o) {
        return switch (o) {
            case L4R _ -> Optional.empty();
            case L4L _ -> Optional.of(0);
            case L4Bot _ -> Optional.of(1);
            case L4Top _ -> Optional.of(-1);
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

    public L4 upper() {
        return new L4Top();
    }

    public L4 lower() {
        return new L4Bot();
    }

    public L4 negate() {
        return new L4R();
    }

    public L4 compose(L4 v) {
        return null;
    }

    @Override
    public String toString() {
        return "Left";
    }
}
