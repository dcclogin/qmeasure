package questions;

import nothings.Nothing;

import java.util.Random;

public class Respondent {

    public Object a; // a = appearance
    private final Object intrinsic;

    // respondent thinks of either nothings.Nothing or a questions.Thing (in a world)
    public Respondent(Object i) {
        this.intrinsic = i;
    }

    // condition to end game?
    // return either nothings.Nothing or a questions.Thing
    public Object respondFinal() {
        return intrinsic;
    }

    public Object confessNothing() {
        a = new Nothing();
        return a;
    }

    public boolean respondT(Thing guess) throws Nonsense {
        if (intrinsic instanceof Nothing) {
            Random rd = new Random();
            boolean ans = rd.nextBoolean();
            return ans && checkConsistency();
        } else if (intrinsic instanceof Thing) {
            return guess.hasDescendant((Thing) intrinsic);
        } else {
            throw new Nonsense();
        }
    }

    public boolean respondP(Property guess) throws Nonsense {
        if (intrinsic instanceof Nothing) {
            Random rd = new Random();
            boolean ans = rd.nextBoolean();
            return ans && checkConsistency();
        } else if (intrinsic instanceof Thing) {
            return ((Thing) intrinsic).hasProperty(guess);
        } else {
            throw new Nonsense();
        }
    }

    // check consistency of previous responds against questions.Transcendental
    // if no checks, there will be either an impossible questions.Thing created, or a contradiction
    public boolean checkConsistency() {
        return true;
    }
}
