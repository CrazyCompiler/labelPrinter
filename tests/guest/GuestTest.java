package guest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class GuestTest {
    Guest guest;

    @Before
    public void setUp() throws Exception {
        String firstName = "Julius";
        String lastName = "Barrows";
        Name name = new Name(firstName,lastName);
        String country = "Macedonia";
        Country address = new Country(country);
        Age age = new Age(18);
        Gender gender = new Gender("Female");
        guest = new Guest(name,age,gender,address);
    }


    @Test
    public void testGetRepresentation_provides_name_representation_formally_without_filters() {
        String[] filters = {};
        String expectedRepresentation = "Ms Julius Barrows";
        assertEquals(expectedRepresentation,guest.getRepresentation("firstName_lastName",filters));
    }

    @Test
    public void testGetRepresentation_provides_name_representation_not_formally_without_filters() {
        String[] filters = {};
        String expectedRepresentation = "Ms Barrows, Julius";
        assertEquals(expectedRepresentation,guest.getRepresentation("lastName_,_firstName",filters));
    }

    @Test
    public void testGetRepresentation_provides_name_representation_formally_with_country_filters() {
        String[] filters = {"country"};
        String expectedRepresentation = "Ms Barrows, Julius, Macedonia";
        assertEquals(expectedRepresentation,guest.getRepresentation("lastName_,_firstName",filters));
    }
    @Test
    public void testEquals_for_Same_Objects() {
        assertTrue(guest.equals(guest));
    }

    @Test
    public void testGetRepresentation_provides_name_representation_formally_with_age_filters() {
        String[] filters = {"age"};
        String expectedRepresentation = "Ms Barrows, Julius, 18";
        assertEquals(expectedRepresentation,guest.getRepresentation("lastName_,_firstName",filters));
    }
    @Test
    public void testGetRepresentation_provides_name_representation_formally_with_age_and_country_filters() {
        String[] filters = {"country","age"};
        String expectedRepresentation = "Ms Julius Barrows, Macedonia, 18";
        assertEquals(expectedRepresentation,guest.getRepresentation("firstName_lastName",filters));
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
}