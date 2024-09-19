package questions;

import nothings.Something;

import java.util.ArrayList;
import java.util.List;

public class Questioner {

    private final Respondent r;
    private List<Thing> gAncestors;
    private List<Thing> gNonAncestors;
    private List<Property> gProperties;
    private List<Property> gNonProperties;

    public Questioner(Respondent r) {
        this.r = r;
        attributeKnowledge();
        gAncestors = new ArrayList<>();
        gNonAncestors = new ArrayList<>();
        gProperties = new ArrayList<>();
        gNonProperties = new ArrayList<>();
    }

    public void attributeKnowledge() {
        this.r.a = new Something();
    }

    // guess a thing t is an ancestor (of nothings.Something) or not
    public boolean guessT(Thing t) throws Nonsense {
        boolean res = this.r.respondT(t);
        if (res) { gAncestors.add(t); }
        else { gNonAncestors.add(t); }
        return res;
    }
    // guess a property p belongs to nothings.Something or not
    public boolean guessP(Property p) throws Nonsense {
        boolean res = this.r.respondP(p);
        if (res) { gProperties.add(p); }
        else { gNonProperties.add(p); }
        return res;
    }

    // make a final guess...may create a new (impossible) questions.Thing outside the 'world'
    // can only make one final guess
    public Thing guessFinal() {
        return null;
    }
}
