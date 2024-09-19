package exchange.values;

import java.util.Optional;
import java.util.Random;

public class ValueBot extends Value {

    public Optional<Integer> compareTo(Value o) {
        if (o instanceof ValueBot) {
            return Optional.of(0);
        } else if (o instanceof ValueL || o instanceof ValueR) {
            return Optional.of(-1);
        } else {
            return Optional.of(-2);
        }
    }

    Value upper() {
        Random r = new Random();
        if (r.nextBoolean()) {
            return new ValueL();
        } else {
            return new ValueR();
        }
    }

    Value lower() {
        return this;
    }

    Value negate() {
        return new ValueTop();
    }
}
