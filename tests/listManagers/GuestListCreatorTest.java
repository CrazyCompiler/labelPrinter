package listManagers;

import guest.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GuestListCreatorTest {
    @Test
    public void testGetGuestList() {
        String sampleCsvData = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n" +
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh\n";

        GuestListCreator guestListCreator = new GuestListCreator(sampleCsvData);
        Name firstGuestName = new Name("Julius", "Barrows");
        Country firstGuestCountry = new Country("Macedonia");
        Gender firstGuestGender = new Gender("Female");
        Age firstGuestAge = new Age(18);
        Guest firstGuest = new Guest(firstGuestName, firstGuestAge, firstGuestGender, firstGuestCountry);

        Name secondGuestName = new Name("Melody", "Dooley");
        Country secondGuestCountry = new Country("Bangladesh");
        Gender secondGuestGender = new Gender("Female");
        Age secondGuestAge = new Age(31);
        Guest secondGuest = new Guest(secondGuestName, secondGuestAge, secondGuestGender, secondGuestCountry);

        Guest[] expectedGuestList = {firstGuest, secondGuest};
        assertArrayEquals(expectedGuestList, guestListCreator.getList());
    }
}