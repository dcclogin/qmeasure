import questions.Property;
import questions.Thing;
import questions.Transcendental;

import java.util.Collections;
import java.util.List;

public class Main {

    public List<Thing> initializeThings() {
        Thing[] arr = new Thing[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thing(
                    Collections.emptyList(),
                    Collections.emptyList(),
                    Collections.emptyList());
        }
        return List.of(arr);
    }

    public List<Property> initializeProperties() {
        Property[] arr = new Property[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Property(String.format("p%d", i));
        }
        return List.of(arr);
    }

    public Transcendental initializeRelations(List<Thing> things,
                                              List<Property> properties) {
        // TODO
        return new Transcendental(things, properties);
    }


    public static void main(String[] args) {
        //questions.Respondent r0 = new questions.Respondent(q0);
        //questions.Questioner q0 = new questions.Questioner(r0);
    }

}