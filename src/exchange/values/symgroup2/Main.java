package exchange.values.symgroup2;

public class Main {
    public static void main(String[] args) {
        S2 id = new S2Id();
        S2 not = new S2X();
        System.out.println(not.compose(not));
        System.out.println(id.isInverse(not));
    }
}
