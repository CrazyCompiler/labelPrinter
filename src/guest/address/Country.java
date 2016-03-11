package guest.address;

import guest.Testables;
import representors.TextRepresentors;

public class Country implements Testables, TextRepresentors {
    private String country;

    public Country(String country) {
        this.country = country;
    }

    public boolean test(String data) {
        String country = data.split("_")[1];
        return this.country.equals(country);
    }

    public String toText() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country1 = (Country) o;

        return country != null ? country.equals(country1.country) : country1.country == null;

    }

    @Override
    public String toString() {
        return "" + this.country;
    }
}
