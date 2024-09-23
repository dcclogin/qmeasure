package exchange;

import exchange.values.Value;
import exchange.values.lattice4.*;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;
import java.util.Random;

public class Commodity {
    private final String name;
    private Object intrinsic;
    private int exchanged;
    private int failure;
    //private int represented;
    //private int representing;
    private @NotNull Optional<Quantity> valueRepresented;
    //private List<SimpleEntry<Commodity, Value>> promises;

    public Commodity(String name) {
        this.name = name;
        intrinsic = new NonValue();
        exchanged = 0;
        failure = 0;
        //promises = new ArrayList<>();
        valueRepresented = Optional.empty();
    }

    public Object getIntrinsic() {
        return intrinsic;
    }
    public int getExchanged() {
        return exchanged;
    }
    public int getFailure() {
        return failure;
    }
    private void tickExchanged() {
        exchanged++;
    }
    private void tickFailure() {
        failure++;
    }
    private void setValueRepresented(Quantity v) {
        valueRepresented = Optional.of(v);
    }
    public @NotNull Optional<Quantity> getValueRepresented() {
        return valueRepresented;
    }

    // represent a Value for another Commodity c
    // may call random in Value
    public Value represent(Commodity c) {
        Random r = new Random();
        int i = r.nextInt(4);
        return switch (i) {
            case 0 -> { yield new L4Bot(); }
            case 1 -> { yield new L4L(); }
            case 2 -> { yield new L4R(); }
            case 3 -> { yield new L4Top(); }
            default -> throw new Error("cannot represent Value.");
        };
    }

    // make an exchange with another Commodity c
    public Optional<Quantity> deal(Commodity c) {
        if (c.equals(this)) return Optional.empty();

        Value tc = this.represent(c);
        Value ct = c.represent(this);
        Quantity meForOther = new Quantity(tc, this);
        Quantity otherForMe = new Quantity(ct, c);

        Random r = new Random();
        int i = r.nextInt(2);

        if (i == 0) {
            this.tickFailure();
            c.tickFailure();
            return Optional.empty();
        } else {
            this.tickExchanged();
            c.tickExchanged();
            this.setValueRepresented(otherForMe);
            c.setValueRepresented(meForOther);
            return Optional.of(meForOther);
        }
    }

    // make an exchange with another commodity c (repeated failure until a deal is made)
    public Optional<Quantity> forceDeal(Commodity c) {
        if (c.equals(this)) return Optional.empty();
        Optional<Quantity> r = this.deal(c);
        while (r.isEmpty()) {
            r = this.deal(c);
        }
        return r;
    }


    // forget the current value represented by another commodity
    public void forgetValue() {
        this.valueRepresented = Optional.empty();
    }
    public void forgetFailure() {
        this.failure = 0;
    }
    public void forgetExchanged() {
        this.exchanged = 0;
    }
    public void forgetAll() {
        forgetValue();
        forgetFailure();
        forgetExchanged();
    }

    // object a is created during a transaction and collected after the transaction?

    // make a promise/contract/order with another Commodity c
    public void promise(Commodity c) {

    }

    @Override
    public String toString() {
        return this.name;
    }
}
