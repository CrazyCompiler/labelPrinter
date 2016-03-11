package designs;

import guest.Gender;
import guest.Name;
import guest.address.City;
import guest.address.Country;
import guest.address.State;
import org.junit.Before;
import org.junit.Test;
import representors.EntityRepresentor;
import representors.NamingConventionGenerator;
import representors.TextRepresentors;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FirstDesignTest {
    HashMap<String, TextRepresentors> guestEntities = new HashMap();
    Name name;
    Gender gender;

    @Before
    public void setUp() throws Exception {
        String firstName = "Julius";
        String lastName = "Barrows";
        gender = new Gender("Female");
        name = new Name(firstName, lastName);
        this.guestEntities.put("city", new City("Veda haven"));
        this.guestEntities.put("state", new State("Vermont"));
        this.guestEntities.put("country", new Country("Macedonia"));
    }


    @Test
    public void testGetRepresentation() {
        String nameRepresentationFormat = "honorific_lastName_,_firstName";

        NamingConventionGenerator namingConvention = new NamingConventionGenerator(nameRepresentationFormat);
        String nameRepresentation = name.getRepresentation(namingConvention, gender.getHonorific());

        String entitiesRepresentationFormat = "space_city_delimiter_space_state_space_lineSeparator_space_country";
        EntityRepresentor entityRepresentor = new EntityRepresentor(entitiesRepresentationFormat);
        String entityRepresentation = entityRepresentor.getRepresentation(this.guestEntities);

        String[] borderSymbols = {"-", "+"};
        FirstDesign design = new FirstDesign();
        String expected = "+---------------------+\n" +
                "| Ms Barrows, Julius  |\n" +
                "+---------------------+\n" +
                "| Veda haven, Vermont |\n" +
                "| Macedonia           |\n" +
                "+---------------------+\n";
        String result = design.getRepresentation(nameRepresentation, entityRepresentation);

        assertEquals(expected, result);
    }
}