package listManagers;

import guest.*;
import guest.address.City;
import guest.address.Country;
import guest.address.State;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

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
        City firstGuestCity = new City("Veda haven");
        State firstGuestState = new State("Vermont");
        Guest firstGuest = new Guest(firstGuestName, firstGuestAge, firstGuestGender, firstGuestCity, firstGuestState, firstGuestCountry);

        Name secondGuestName = new Name("Melody", "Dooley");
        City secondGuestCity = new City("West Shanna");
        State secondGuestState = new State("Vermont");
        Country secondGuestCountry = new Country("Bangladesh");
        Gender secondGuestGender = new Gender("Female");
        Age secondGuestAge = new Age(31);
        Guest secondGuest = new Guest(secondGuestName, secondGuestAge, secondGuestGender, secondGuestCity,secondGuestState,secondGuestCountry);
        ArrayList<Guest> expectedGuestList = new ArrayList<Guest>();
        expectedGuestList.add(firstGuest);
        expectedGuestList.add(secondGuest);
        assertTrue(expectedGuestList.equals(guestListCreator.getList()));
    }
}