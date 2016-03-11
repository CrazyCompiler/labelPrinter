package filters;

import guest.*;
import guest.address.City;
import guest.address.Country;
import guest.address.State;
import listManagers.GuestListCreator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class FilterTest {
    ArrayList<Guest> guests;
    Guest firstGuest;
    Guest secondGuest;

    @Before
    public void setUp() throws Exception {
        String sampleCsvData = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n" +
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh\n";

        GuestListCreator guestListCreator = new GuestListCreator(sampleCsvData);
        guests = guestListCreator.getList();

        Name firstGuestName = new Name("Julius", "Barrows");
        Country firstGuestCountry = new Country("Macedonia");
        Gender firstGuestGender = new Gender("Female");
        Age firstGuestAge = new Age(18);
        City firstGuestCity = new City("Veda haven");
        State firstGuestState = new State("Vermont");
        firstGuest = new Guest(firstGuestName, firstGuestAge, firstGuestGender, firstGuestCity, firstGuestState, firstGuestCountry);

        Name secondGuestName = new Name("Melody", "Dooley");
        City secondGuestCity = new City("West Shanna");
        State secondGuestState = new State("Vermont");
        Country secondGuestCountry = new Country("Bangladesh");
        Gender secondGuestGender = new Gender("Female");
        Age secondGuestAge = new Age(31);

        secondGuest = new Guest(secondGuestName, secondGuestAge, secondGuestGender, secondGuestCity,secondGuestState,secondGuestCountry);

    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_from_Bangladeshs() {
        String[] filters = {"country_Bangladesh"};
        ArrayList<Guest> expectedGuestList = new ArrayList<Guest>();
        expectedGuestList.add(secondGuest);
        Filter filter = new Filter(filters);
        assertTrue(expectedGuestList.equals(filter.getFilteredList(guests)));
    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_bellow_20() {
        String[] filters = {"age_bellow_20"};
        ArrayList<Guest> expectedGuestList = new ArrayList<Guest>();
        expectedGuestList.add(firstGuest);
        Filter filter = new Filter(filters);
        assertTrue(expectedGuestList.equals(filter.getFilteredList(guests)));
    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_above_20_and_from_Bangaladesh() {
        String[] filters = {"country_Bangladesh", "age_above_20"};
        ArrayList<Guest> expectedGuestList = new ArrayList<Guest>();
        expectedGuestList.add(secondGuest);
        Filter filter = new Filter(filters);
        assertTrue(expectedGuestList.equals(filter.getFilteredList(guests)));
    }


}