package representors;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class NamingConventionGeneratorTest {
    @Test
    public void testGetRepresentationForFemale() throws Exception {
        String firstName = "Julius";
        String lastName = "Barrows";

        NamingConventionGenerator convension = new NamingConventionGenerator("firstName_lastName");
        String expected = " Julius Barrows";
        assertTrue(expected.equals(convension.getRepresentation(firstName,lastName)));
    }


    @Test
    public void testGetRepresentationForMale() throws Exception {
        String firstName = "Gavin";
        String lastName = "Hyatt";

        NamingConventionGenerator convension = new NamingConventionGenerator("lastName_,_firstName");
        String expected = " Hyatt, Gavin";
        assertTrue(expected.equals(convension.getRepresentation(firstName,lastName)));
    }
}