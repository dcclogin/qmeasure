package language;

public class Main {
    public static void main(String[] args) {
        Signifier s2 = null;
        Signifier s1 = new Signifier(s2);
        s2 = new Signifier(s1);
    }
}
