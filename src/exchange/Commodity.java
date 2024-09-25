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

    /*
        represent a Value for another Commodity c
    */
    public Value represent(Commodity other) {
        if (valueRepresented.isPresent()) {
            if (valueRepresented.get().getUnit().equals(other)) {
                return valueRepresented.get().getValue().inverse();
            }
        }
        return Transcendental.contingentValS4();
    }


    /*
        no imposition of inverse
    */
    public Quantity reflect(Commodity other) {
        assert (!other.equals(this));
        Value to = this.represent(other);
        Value ot = other.represent(this);
        Quantity meForOther = new Quantity(to, this);
        Quantity otherForMe = new Quantity(ot, other);
        this.setValueRepresented(otherForMe);
        other.setValueRepresented(meForOther);
        return meForOther;
    }


    /*
        make an exchange with another Commodity c
        no imposition of commutativity
        TODO: refine the role of Mediator
    */
    public Optional<Quantity> deal(Commodity other) {
        if (other.equals(this)) return Optional.empty();

        Value to = this.represent(other);
        Value ot = other.represent(this);
        /* do we need a new mediator for each deal */
        Mediator m = new Mediator(to, ot);
        if (m.mediate()) {
            Quantity meForOther = new Quantity(m.get_a(), this);
            Quantity otherForMe = new Quantity(m.get_b(), other);

            this.setValueRepresented(otherForMe);
            other.setValueRepresented(meForOther);
            return Optional.of(meForOther);
        } else {
            /* keep antagonistic */
            return Optional.empty();
        }
    }

    /*
        make an exchange with another commodity c
        repeated failure until a deal is made
    */
    public Quantity forceDeal(Commodity c) {
        Optional<Quantity> r = this.deal(c);
        while (r.isEmpty()) {
            r = this.deal(c);
        }
        return r.get();
    }


    /*
        impose commutativity
        Value implicitly mediated by a third term
    */
    public Optional<Quantity> commDeal(Commodity other) {
        if (this.equals(other)) return Optional.empty();
        Optional<Quantity> qo = other.getValueRepresented();
        Optional<Quantity> qt = this.getValueRepresented();
        if (qo.isEmpty() || qt.isEmpty()) {
            return this.deal(other);
        } else if (qo.get().getUnit() != qt.get().getUnit()) {
            return this.deal(other);
        } else {
            Value vo = qo.get().getValue();
            Value vt = qt.get().getValue();
            Value vto = vt.inverse().compose(vo);
            Value vot = vo.inverse().compose(vt);
            Quantity meForOther = new Quantity(vto, this);
            Quantity otherForMe = new Quantity(vot, other);
            this.setValueRepresented(otherForMe);
            other.setValueRepresented(meForOther);
            return Optional.of(meForOther);
        }
    }


    /*
        forget the current value represented by another commodity
    */
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

    public void promise(Commodity c) {}

    @Override
    public String toString() {
        return this.name;
    }
}
