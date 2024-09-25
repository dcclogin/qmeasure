package exchange;

import exchange.values.Value;
import exchange.values.symgroup2.S2;

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
    /* no commutativity */
    public static void ex2 () {
        System.out.println("[Example 2: 3-commodity]:");
        Commodity c1 = new Commodity("c1");
        Commodity c2 = new Commodity("c2");
        Commodity c3 = new Commodity("c3");

        c1.forceDeal(c2);
        c3.forceDeal(c1);
        //c3.forceDeal(c2);

        Quantity q1, q2, q3;
        q1 = c1.getValueRepresented().get();
        q2 = c2.getValueRepresented().get();
        q3 = c3.getValueRepresented().get();
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        Value v1 = q1.getValue().compose(q2.getValue());

        System.out.println("After 3rd");

        c3.commDeal(c2);

        q1 = c1.getValueRepresented().get();
        q2 = c2.getValueRepresented().get();
        q3 = c3.getValueRepresented().get();
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        Value v2 = q2.getValue();

        System.out.println("commutative?");
        System.out.println(v1);
        System.out.println(v2);

    }

    public static void ex3() {
        Money<S2> m0 = new Money<>("m0");
        System.out.println(m0.selfRepresent());
    }

    // atonal world
    // without intervene of master-signifier
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }
}
