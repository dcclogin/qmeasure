package exchange.values.symgroup4;

public class Main {
    public static void main(String[] args) {
        S4 id = new S4Id();
        S4 e1 = new S4E(new int[]{1,2,3,0});
        S4 e2 = new S4E(new int[]{2,0,3,1});
        S4 e1inv = e1.inverse();
        S4 e2inv = e2.inverse();

        System.out.println(e1.compose(e2));
        System.out.println(e1.compose(e1inv));
        System.out.println(e1inv.compose(e1));
        System.out.println(e1.inverse().isInverse(e1));
        System.out.println(e1.isInverse(e1.inverse()));
    }
}
