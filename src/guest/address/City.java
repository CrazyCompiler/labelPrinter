package guest.address;

import representors.TextRepresentors;

public class City implements TextRepresentors {
    private String city;
    public City(String city) {
        this.city = city;
    }

    public String toText() {
        return city;
    }
}
