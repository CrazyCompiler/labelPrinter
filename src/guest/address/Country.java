package guest.address;

import guest.Testables;
import representors.TextRepresentors;

public class Country implements Testables, TextRepresentors {
    private String country;

    public Country(String country) {
        this.country = country;
    }

    public boolean test(String data) {
        return this.country.equals(data);
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

}
