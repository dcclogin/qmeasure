package questions;

public class Property {
    private int id;
    private final String name;

    public Property(String name) {
        this.name = name;
    }

    public boolean belongTo(Thing t) {
        return t.hasProperty(this);
    }
}
