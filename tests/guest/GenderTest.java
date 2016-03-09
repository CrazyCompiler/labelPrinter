package guest;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GenderTest {
    @Test
    public void testGetHonorific_provides_honorofic_for_female() {
        Gender gender = new Gender("Female");
        String expectedHonorific = "Ms";
        assertTrue(expectedHonorific.equals(gender.getHonorific()));
    }
}