package exchange;

import exchange.values.Value;
import exchange.values.lattice4.*;
import org.jetbrains.annotations.NotNull;
import java.util.Optional;


public class Commodity {
    private final String name;
    private final Object intrinsic;
    private int exchanged;
    private int failure;
    private @NotNull Optional<Quantity> valueRepresented;
    //private int represented;
    //private int representing;
    //private List<SimpleEntry<Commodity, Value>> promises;

    public Commodity(String name) {
        this.name = name;
        intrinsic = new NonValue();
        exchanged = 0;
        failure = 0;
        valueRepresented = Optional.empty();
        //promises = new ArrayList<>();
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
    // "one" this for ??? c
    public Value represent(Commodity c) {
        if (valueRepresented.isPresent()) {
            if (valueRepresented.get().getUnit().equals(c)) {
                return valueRepresented.get().getValue().inverse();
            }
        }
        //return Transcendental.contingentValL4();
        //return Transcendental.contingentValNat(1, 10);
        return Transcendental.contingentValS4();
    }

    // make an exchange with another Commodity c
    // strict imposition of inverse for S4
    // TODO: refine the role of Mediator
    public Optional<Quantity> deal(Commodity c) {
        if (c.equals(this)) return Optional.empty();

        Value tc = this.represent(c);
        Value ct = c.represent(this);

        Mediator m = new Mediator(tc, ct);
        if (m.mediate()) {
            Quantity meForOther = new Quantity(m.get_a(), this);
            Quantity otherForMe = new Quantity(m.get_b(), c);

            this.tickExchanged();
            c.tickExchanged();
            this.setValueRepresented(otherForMe);
            c.setValueRepresented(meForOther);
            return Optional.of(meForOther);
        } else {
            // also keep antagonistic?
            this.tickFailure();
            c.tickFailure();
            return Optional.empty();
        }
    }

    // make an exchange with another commodity c (repeated failure until a deal is made)
    public Quantity forceDeal(Commodity c) {
        //if (c.equals(this)) return Optional.empty();
        Optional<Quantity> r = this.deal(c);
        while (r.isEmpty()) {
            r = this.deal(c);
        }
        return r.get();
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
