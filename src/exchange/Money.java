package exchange;

import exchange.values.Value;
import exchange.values.symgroup2.S2;

// "evaluator"
// emergence of money as a master-signifier
// one commodity trying to represent Value for all commodities
public class Money extends Commodity {

    public Money(String name) {
        super(name);
    }

    // complementarity:
    // the more
    @Override
    public Value represent(Commodity c) {
        return Transcendental.contingentValS2();
    }
}
