package guest;

import designs.Designs;
import designs.FirstDesign;
import guest.address.City;
import guest.address.Country;
import guest.address.State;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;

    @Before
    public void setUp() throws Exception {
        String firstName = "Julius";
        String lastName = "Barrows";
        Name name = new Name(firstName, lastName);
        Country country = new Country("Macedonia");
        Age age = new Age(18);
        Gender gender = new Gender("Female");
        City city = new City("Veda haven");
        State state = new State("Vermont");
        guest = new Guest(name, age, gender, city, state, country);
    }


    @Test
    public void testEquals_for_Same_Objects() {
        assertTrue(guest.equals(guest));
    }

    @Test
    public void testIsEligible_test_if_guest_is_eligible_and_returns_true() {
        String[] filters = {"country_Macedonia"};
        assertTrue(guest.isEligible(filters));
    }

    @Test
    public void testIsEligible_test_if_guest_is_eligible_and_returns_true_for_age_below_20() {
        String[] filters = {"age_bellow_20"};
        assertTrue(guest.isEligible(filters));
    }

    @Test
    public void testIsEligible_test_if_guest_is_eligible_and_returns_false_for_age_above_20() {
        String[] filters = {"age_above_20"};
        assertFalse(guest.isEligible(filters));
    }

    @Test
    public void testGetRepresentation_provides_name_representation_formally_with_age_and_country_filters() {
        String[] entries = {"country", "age"};
        String expectedRepresentation = "Ms Julius Barrows, Macedonia, 18";
        String nameRepresentation = "honorific_lastName_,_firstName";
        String entityRepresentation = "space_city_delimiter_space_state_space_lineSeparator_space_country";
        String[] borderSymbol = {"-", "+"};
        Designs design = new FirstDesign();
        String expected = "+---------------------+\n" +
                "| Ms Barrows, Julius  |\n" +
                "+---------------------+\n" +
                "| Veda haven, Vermont |\n" +
                "| Macedonia           |\n" +
                "+---------------------+\n";
        assertEquals(expected, guest.getRepresentation(nameRepresentation, entityRepresentation, design));
    }
}