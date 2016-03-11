package guest.address;

import representors.TextRepresentors;

public class State implements TextRepresentors {
    private String state;
    public State(String state) {
        this.state = state;
    }

    public String toText() {
        return state;
    }
}
