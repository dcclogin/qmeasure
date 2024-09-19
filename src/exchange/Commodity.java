package exchange;

import exchange.values.*;
import nothings.Nothing;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Commodity {
    private Object intrinsic;
    private int exchanged;
    private int failure;
    //private int represented;
    //private int representing;
    private List<SimpleEntry<Commodity, Value>> promises;

    public Commodity() {
        intrinsic = new Nothing();
        exchanged = 0;
        failure = 0;
        promises = new ArrayList<>();
    }

    public int getExchanged() {
        return exchanged;
    }
    public int getFailure() {
        return failure;
    }
    public void tickExchanged() {
        exchanged++;
    }
    public void tickFailure() {
        failure++;
    }

    // represent a Value for another Commodity c
    public Value represent(Commodity c) {
        Random r = new Random();
        int i = r.nextInt(4);
        return switch (i) {
            case 0 -> {
                yield new ValueBot();
            }
            case 1 -> {
                yield new ValueL();
            }
            case 2 -> {
                yield new ValueR();
            }
            case 3 -> {
                yield new ValueTop();
            }
            default -> throw new Error("cannot represent Value.");
        };
    }

    // make an exchange with another Commodity c
    public Optional<SimpleEntry<Value, Value>> deal(Commodity c) {
        Value meForOther = this.represent(c);
        Value otherForMe = c.represent(this);
        Random r = new Random();
        int i = r.nextInt(2);
        if (i == 0) {
            this.tickFailure();
            c.tickFailure();
            return Optional.empty();
        } else {
            this.tickExchanged();
            c.tickExchanged();
            return Optional.of(new SimpleEntry<>(meForOther, otherForMe));
        }
    }

    // make a promise/contract/order with another Commodity c
    public void promise(Commodity c) {

    }
}
