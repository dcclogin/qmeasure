package exchange;

import exchange.values.Value;

// metric; dimension of unit
public class Quantity {
    private final Value value;
    private final Commodity unit;
    public Quantity(Value value, Commodity unit) {
        this.value = value;
        this.unit = unit;
    }

    public Value getValue() {
        return value;
    }
    public Commodity getUnit() {
        return unit;
    }
    @Override
    public String toString() {
        return value.toString() + " " + unit.toString();
    }
}
