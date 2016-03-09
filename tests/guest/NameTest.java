package guest;

import org.junit.Test;
import representors.NamingConventionGenerator;

import static org.junit.Assert.assertTrue;

public class NameTest {
    @Test
    public void testGetRepresentation_which_provides_name_represenation_according_to_given_representation() {
        String firstName = "Rodolfo";
        String secondName = "Balistreri";
        Name name = new Name(firstName,secondName);
        NamingConventionGenerator convention= new NamingConventionGenerator("firstName_lastName");
        String expectedOutput = " Rodolfo Balistreri";
        assertTrue(expectedOutput.equals(name.getRepresentation(convention)));
    }
}