package guest;

public class Country implements Testables{
    private String country;

    public Country(String country) {
        this.country = country;
    }

    public boolean test(String country) {
        return this.country.equals(country);
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
