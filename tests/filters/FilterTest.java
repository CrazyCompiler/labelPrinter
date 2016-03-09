package filters;

import guest.*;
import listManagers.GuestListCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FilterTest {
    Guest[] guests;
    Guest firstGuest;
    Guest secondGuest;

    @Before
    public void setUp() throws Exception {
        String sampleCsvData = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n"+
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh\n";

        GuestListCreator guestListCreator = new GuestListCreator(sampleCsvData);
        guests = guestListCreator.getList();

        Name firstGuestName = new Name("Julius","Barrows");
        Country firstGuestCountry = new Country("Macedonia");
        Gender firstGuestGender = new Gender("Female");
        Age firstGuestAge = new Age(18);

        firstGuest = new Guest(firstGuestName,firstGuestAge,firstGuestGender,firstGuestCountry);

        Name secondGuestName = new Name("Melody","Dooley");
        Country secondGuestCountry = new Country("Bangladesh");
        Gender secondGuestGender = new Gender("Female");
        Age secondGuestAge = new Age(31);

        secondGuest = new Guest(secondGuestName,secondGuestAge,secondGuestGender,secondGuestCountry);

    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_from_Bangladeshs(){
        String[] filters = {"country_Bangladesh"};
        Guest[] expectedGuestList = {secondGuest};
        Filter filter = new Filter(filters);
        assertArrayEquals(expectedGuestList,filter.getFilteredList(guests));
    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_bellow_20(){
        String[] filters = {"age_bellow_20"};
        Guest[] expectedGuestList = {firstGuest};
        Filter filter = new Filter(filters);
        assertArrayEquals(expectedGuestList,filter.getFilteredList(guests));
    }

    @Test
    public void testGetFilteredList_provides_list_of_guest_above_20_and_from_Bangaladesh(){
        String[] filters = {"country_Bangladesh","age_above_20"};
        Guest[] expectedGuestList = {secondGuest};
        Filter filter = new Filter(filters);
        assertArrayEquals(expectedGuestList,filter.getFilteredList(guests));
    }


}