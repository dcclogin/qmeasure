package language;

// attempt to model a concept of "quantum variable" based on "signifier"
public class Signifier {

    private Signifier other;
    private Subject subject;

    public Signifier(Signifier other) {
        this.other = other;
    }

    public Signifier getOther() {
        return other;
    }
}
