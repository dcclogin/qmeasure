package exchange.values.natural;

import static exchange.values.natural.NOperators.*;

public class Main {
    public static void main(String[] args) {
        Nat n = makeNat(5);
        System.out.println(factNat(n.sub1()).toInteger());
        System.out.println(makeNat(5).comparedTo(makeNat(3)));
    }
}
