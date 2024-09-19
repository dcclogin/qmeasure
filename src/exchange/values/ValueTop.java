package exchange.values;

import java.util.Optional;
import java.util.Random;

public class ValueTop extends Value {

    public Optional<Integer> compareTo(Value o) {
        if (o instanceof ValueTop) {
            return Optional.of(0);
        } else if (o instanceof ValueL || o instanceof ValueR) {
            return Optional.of(1);
        } else {
            return Optional.of(2);
        }
    }

    Value upper() {
        return this;
    }

    Value lower() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return new ValueL();
        } else {
            return new ValueR();
        }
    }

    Value negate() {
        return new ValueBot();
    }
}
