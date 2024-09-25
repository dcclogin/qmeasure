package exchange;

import exchange.values.Value;
import exchange.values.lattice4.L4Bot;
import exchange.values.lattice4.L4L;
import exchange.values.lattice4.L4R;
import exchange.values.lattice4.L4Top;
import exchange.values.symgroup2.S2Id;
import exchange.values.symgroup2.S2X;
import exchange.values.symgroup4.S4E;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static exchange.values.natural.NOperators.makeNat;

// a world of commodities
public class Transcendental {
    private List<Commodity> commodities;
    private List<Money> moneys;

    public Transcendental(List<Commodity> commodities, List<Money> moneys) {
        this.commodities = commodities;
        this.moneys = moneys;
    }

    public static Value contingentValL4() {
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

    public static Value contingentValNat(int lower, int upper) {
        Random r = new Random();
        int num = r.nextInt(lower, upper);
        return makeNat(num);
    }

    public static Value contingentValS4() {
        ArrayList<Integer> a = new ArrayList<>(List.of(new Integer[]{0,1,2,3}));
        Collections.shuffle(a);
        int[] es = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            es[i] = a.get(i);
        }
        return new S4E(es);
    }

    public static Value contingentValS2() {
        Random r = new Random();
        boolean i = r.nextBoolean();
        if (i) { return new S2Id(); }
        else { return new S2X(); }
    }
}
