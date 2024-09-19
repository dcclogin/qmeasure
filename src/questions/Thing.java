package questions;

import java.util.List;

public class Thing {

    private final List<Property> ps;
    private final List<Thing> subs;
    private final List<Thing> supers;

    public Thing(List<Property> properties,
                 List<Thing> subthings,
                 List<Thing> superthings) {
        this.ps = properties;
        this.subs = subthings;
        this.supers = superthings;
    }

    public void addProperty(Property p) {
        this.ps.add(p);
    }
    public void removeProperty(Property p) {
        this.ps.remove(p);
    }
    public boolean hasProperty(Property p) {
        return ps.contains(p);
    }

    public List<Thing> getSubs() {
        return subs;
    }
    public void addSubthings(Thing t) {
        this.subs.add(t);
        t.supers.add(this);
    }
    public void removeSubthings(Thing t) {
        this.subs.remove(t);
        t.supers.remove(this);
    }

    public List<Thing> getSupers() {
        return supers;
    }
    public void addSupers(Thing t) {
        this.supers.add(t);
        t.subs.add(this);
    }
    public void removeSupers(Thing t) {
        this.supers.remove(t);
        t.subs.remove(this);
    }

    public boolean hasChild(Thing t) {
        return this.subs.contains(t);
    }
    public boolean isChildOf(Thing t) {
        return t.subs.contains(this);
    }
    public boolean hasParent(Thing t) { return this.supers.contains(t); }
    public boolean isParentOf(Thing t) { return t.supers.contains(this); }

    public boolean hasDescendant(Thing t) {
        for (Thing i : this.subs) {
            return (i.equals(t) || i.hasDescendant(t));
        }
        return false;
    }
    public boolean hasAncestor(Thing t) {
        for (Thing i : this.supers) {
            return (i.equals(t) || i.hasAncestor(t));
        }
        return false;
    }
}
