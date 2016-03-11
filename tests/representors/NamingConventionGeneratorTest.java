package representors;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class NamingConventionGeneratorTest {
    @Test
    public void testGetRepresentationForFemale() throws Exception {
        String firstName = "Julius";
        String lastName = "Barrows";

        NamingConventionGenerator convension = new NamingConventionGenerator("honorific_firstName_lastName");
        String expected = " Mr Julius Barrows";
        String honorific = "Mr";
        assertTrue(expected.equals(convension.getRepresentation(firstName,lastName,honorific)));
    }


    @Test
    public void testGetRepresentationForMale() throws Exception {
        String firstName = "Gavin";
        String lastName = "Hyatt";

        NamingConventionGenerator convension = new NamingConventionGenerator("honorific_lastName_,_firstName");
        String expected = " Mr Hyatt, Gavin";
        String honorific = "Mr";
        assertEquals(expected,convension.getRepresentation(firstName,lastName,honorific));
    }
}