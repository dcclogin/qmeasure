package exchange;

import exchange.values.Value;
import exchange.values.symgroup2.S2;
import exchange.values.symgroup2.S2Id;

import java.util.Optional;

// "evaluator"
// emergence of money as a master-signifier
// one commodity trying to represent Value for all commodities
public class Money<T> extends Commodity {

    public Money(String name) {
        super(name);
    }

    // complementarity:
    // the more ... the less ...
    // has the right to self-representing (tautological / master-signifier)
    @Override
    public Value represent(Commodity c) {
        if (c.equals(this)) {
            return new S2Id();
        }
        return Transcendental.contingentValS2();
    }

    public Value selfRepresent() {
        return this.represent(this);
    }

    // should commDeal only be imposed when intervened by Money?
    @Override
    public Optional<Quantity> commDeal(Commodity c) {
        return Optional.empty();
    }
}
