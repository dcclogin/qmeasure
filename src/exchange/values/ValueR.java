package exchange.values;

import java.util.Optional;

public class ValueR extends Value {

    public Optional<Integer> compareTo(Value o) {
        return switch (o) {
            case ValueR _ -> Optional.of(0);
            case ValueL _ -> Optional.empty();
            case ValueBot _ -> Optional.of(1);
            case ValueTop _ -> Optional.of(-1);
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

    Value upper() {
        return new ValueTop();
    }

    Value lower() {
        return new ValueBot();
    }

    Value negate() {
        return new ValueL();
    }
}
