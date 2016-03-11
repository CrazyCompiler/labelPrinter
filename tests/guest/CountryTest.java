package guest;

import guest.address.Country;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CountryTest {
    Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country("Macedonia");
    }

    @Test
    public void testHasSameCountry() {
        assertTrue(country.test("country_Macedonia"));
    }
}