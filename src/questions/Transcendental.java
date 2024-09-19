package questions;

import java.util.ArrayList;
import java.util.List;

// transcendental frame of Things and Properties...i.e. a 'world'
// properties are not inheritable in current configuration
// may accept new things-properties created during QR sessions...

public class Transcendental {

    public List<Thing> things;
    public List<Property> properties;
    public final int QLIMIT = 10;

    public Transcendental(List<Thing> things, List<Property> properties) {
        this.things = things;
        this.properties = properties;
    }

    // e.g. balanced tree or manual
    public void initializeHierarchy() {}

    public void addProperty(Property p) {
        properties.add(p);
    }
    public void addThing(Thing t) {
        things.add(t);
    }
    public void setProperties(Thing t, Property p) {
        properties.add(p);
        things.add(t);
        t.addProperty(p);
    }
    public void setSupers(Thing t, Thing s) {
        things.add(t);
        things.add(s);
        t.addSupers(s);
    }
    public void setSubs(Thing t, Thing s) {
        things.add(t);
        things.add(s);
        t.addSubthings(s);
    }

    // get those things in this world that has no ancestors
    public List<Thing> getTopLevelThings() {
        List<Thing> topLevelThings = new ArrayList<>();
        for (Thing t : things) {
            if (t.getSupers().isEmpty()) {
                topLevelThings.add(t);
            }
        }
        return topLevelThings;
    }
    // get those things in this world that has no descendants
    public List<Thing> getBottomLevelThings() {
        List<Thing> bottomLevelThings = new ArrayList<>();
        for (Thing t : things) {
            if (t.getSubs().isEmpty()) {
                bottomLevelThings.add(t);
            }
        }
        return bottomLevelThings;
    }


    // given a list of ancestors, find all possible things
    public List<Thing> filterByAncestors(List<Thing> as) {
        if (as.isEmpty()) {
            return things;
        } else {
            Thing a = as.getFirst();
            List<Thing> res = filterByAncestors(as.subList(1, as.size()));
            res.removeIf(t -> !t.hasAncestor(a));
            return res;
        }
    }
    public List<Thing> filterByNonAncestors(List<Thing> nas) {
        if (nas.isEmpty()) {
            return things;
        } else {
            Thing a = nas.getFirst();
            List<Thing> res = filterByNonAncestors(nas.subList(1, nas.size()));
            res.removeIf(t -> t.hasAncestor(a));
            return res;
        }
    }

    // given a list of properties, find all possible things
    public List<Thing> filterByProperties(List<Property> ps) {
        if (ps.isEmpty()) {
            return things;
        } else {
            Property p = ps.getFirst();
            List<Thing> res = filterByProperties(ps.subList(1, ps.size()));
            res.removeIf(t -> !t.hasProperty(p));
            return res;
        }
    }
    public List<Thing> filterByNonProperties(List<Property> nps) {
        if (nps.isEmpty()) {
            return things;
        } else {
            Property p = nps.getFirst();
            List<Thing> res = filterByNonProperties(nps.subList(1, nps.size()));
            res.removeIf(t -> t.hasProperty(p));
            return res;
        }
    }

    // traverse things many times
    public List<Thing> filterAll(List<Thing> as,
                                 List<Thing> nas,
                                 List<Property> ps,
                                 List<Property> nps) {

        List<Thing> asRes = filterByAncestors(as);
        List<Thing> nasRes = filterByNonAncestors(nas);
        List<Thing> psRes = filterByProperties(ps);
        List<Thing> npsRes = filterByNonProperties(nps);

        List<Thing> res = new ArrayList<>();

        for (Thing t : things) {
            if (asRes.contains(t)
                && nasRes.contains(t)
                && psRes.contains(t)
                && npsRes.contains(t)) {
                res.add(t);
            }
        }
        return res;
    }

    // traverse things once
    public List<Thing> filterAll2() {
        return null;
    }
}
