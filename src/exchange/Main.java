package exchange;

public class Main {
    public static void main(String[] args) {
        Commodity c1 = new Commodity("c1");
        Commodity c2 = new Commodity("c2");
        Commodity c3 = new Commodity("c3");
        c1.forceDeal(c2); // c1 measures c2 which gives c1's representation of c2's Value
        c1.forceDeal(c3);
        c2.forceDeal(c1);
        System.out.println(c1.getExchanged() + " "
                + c1.getFailure() + " "
                + c2.getExchanged() + " "
                + c2.getFailure());
        // no identity, no inverse, no commutativity
        System.out.println(c1.getValueRepresented());
        System.out.println(c2.getValueRepresented());
        System.out.println(c3.getValueRepresented());

        c2.forgetValue();
        System.out.println(c2.getValueRepresented());

        // emergence of money as a master-signifier
        // trying to represent Value for all commodities

        System.out.println(Transcendental.contingentValS4());
    }
}
