package exchange;

public class Main {
    public static void main(String[] args) {
        Commodity c1 = new Commodity();
        Commodity c2 = new Commodity();
        Commodity c3 = new Commodity();
        c1.deal(c2); // c1 measures c2 which gives c1's representation of c2's Value
        c1.deal(c3);
        System.out.println(c1.getExchanged() + " " + c1.getFailure() + " " + c2.getExchanged() + " " + c2.getFailure());
    }
}
