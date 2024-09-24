package exchange;

import exchange.values.Value;

public class Main {

    /* 2-commodity interaction */
    /* enforce inverse */
    public static void ex1() {
        System.out.println("[Example 1: 2-commodity]:");
        Commodity c1 = new Commodity("c1");
        Commodity c2 = new Commodity("c2");

        // c1 "measures" c2
        // c1 represents / reflects Value of c2
        Quantity res = c1.forceDeal(c2);

        Quantity q1 = c1.getValueRepresented().get();
        Quantity q2 = c2.getValueRepresented().get();

        Value v1 = q1.getValue();
        Value v2 = q2.getValue();

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(res.equals(q2));
        System.out.println(v1.isInverse(v2));
    }

    /* 3-commodity */
    /* enforce commutativity ??? */
    public static void ex2 () {
        System.out.println("[Example 2: 3-commodity]:");
        Commodity c1 = new Commodity("c1");
        Commodity c2 = new Commodity("c2");
        Commodity c3 = new Commodity("c3");

        c1.forceDeal(c2);
        c3.forceDeal(c1);
        // c3.deal(c2) ???

        Quantity q1, q2, q3;
        Value v1, v2, v3;
        q1 = c1.getValueRepresented().get();
        q2 = c2.getValueRepresented().get();
        q3 = c3.getValueRepresented().get();
        v1 = q1.getValue();
        v2 = q2.getValue();
        v3 = q3.getValue();

        // no identity, no inverse, no commutativity
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(v1.isInverse(v3));
    }


    public static void main(String[] args) {
        ex1();
        ex2();
    }
}
