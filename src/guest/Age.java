package guest;

import representors.TextRepresentors;

import java.util.HashMap;

public class Age implements Testables, TextRepresentors {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean test(String data) {
        String expression = data.split("_")[0];
        String limit = data.split("_")[1];
        int threshHold = Integer.parseInt(limit);
        HashMap<String, Boolean> choices = new HashMap();
        choices.put("above", threshHold < this.age);
        choices.put("bellow", threshHold > this.age);
        choices.put("equal", threshHold == this.age);
        return choices.get(expression);
    }

    public String toText() {
        return age+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Age)) return false;

        Age age1 = (Age) o;

        return age == age1.age;

    }

    @Override
    public String toString() {
        return "" + age;
    }
}
