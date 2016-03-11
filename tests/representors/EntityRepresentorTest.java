package representors;

import guest.address.City;
import guest.address.Country;
import guest.address.State;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class EntityRepresentorTest {
    @Test
    public void testGetRepresentation_provides_representation_according_to_given_format() {
        City city = new City ("West Shanna");
        State state = new State("Georgia");
        Country country = new Country("Bangladesh");
        HashMap<String,TextRepresentors> elements = new HashMap();
        elements.put("city",city);
        elements.put("state",state);
        elements.put("country",country);
        EntityRepresentor entityRepresentor= new EntityRepresentor("space_city_delimiter_space_state_lineSeparator_space_country");
        String expectedRepresentation = " West Shanna, Georgia\n Bangladesh";
        assertEquals(expectedRepresentation,entityRepresentor.getRepresentation(elements));
    }
}