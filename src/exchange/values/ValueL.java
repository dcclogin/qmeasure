package exchange.values;

import java.util.Optional;

public class ValueL implements Value {
    public Optional<Integer> compareTo(Value o) {
        return switch (o) {
            case ValueR _ -> Optional.empty();
            case ValueL _ -> Optional.of(0);
            case ValueBot _ -> Optional.of(1);
            case ValueTop _ -> Optional.of(-1);
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

    public Value upper() {
        return new ValueTop();
    }

    public Value lower() {
        return new ValueBot();
    }

    public Value negate() {
        return new ValueR();
    }

    public Value compose(Value v) {
        return null;
    }
}
