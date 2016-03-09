package representors;

import guest.Guest;
import listManagers.GuestListCreator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RepresentativeTest {
    @Test
    public void testGetRepresentation_without_filters_first_name_last_name_convention() {
        String data = "Ola,Kreiger,Male,36,Katlynn view,Vermont,Romania\n" +
                "Rodolfo,Balistreri,Male,32,Crooks ton,Georgia,Bangladesh\n" +
                "Juana,Champlin,Female,26,West Shanna,Georgia,Bangladesh";
        GuestListCreator guestListCreator = new GuestListCreator(data);

        String[] filters = new String[0];
        Guest[] guests = guestListCreator.getList();

        Representative representative = new Representative(guests);
        String expectedOutput = "Mr Ola Kreiger\n" +
                "Mr Rodolfo Balistreri\n" +
                "Ms Juana Champlin\n";
        assertTrue(expectedOutput.equals(representative.getRepresentation("-f",filters)));
    }

    @Test
    public void testGetRepresentation_with_filters() {
        String data = "Ola,Kreiger,Male,36,Katlynn view,Vermont,Bangladesh\n" +
                "Rodolfo,Balistreri,Male,32,Crooks ton,Georgia,Bangladesh\n" +
                "Juana,Champlin,Female,26,West Shanna,Georgia,Bangladesh";
        GuestListCreator guestListCreator = new GuestListCreator(data);

        String[] filters = {"country_Bangaladesh","age_20"};
        Guest[] guests = guestListCreator.getList();

        Representative representative = new Representative(guests);
        String expectedOutput = "Mr Ola Kreiger, Bangladesh, 36\n" +
                "Mr Rodolfo Balistreri, Bangladesh, 32\n" +
                "Ms Juana Champlin, Bangladesh, 26\n";
        assertEquals(expectedOutput,representative.getRepresentation("-f",filters));
    }


    @Test
    public void testGetRepresentationForWrongInput() {
        String data = "Mr Ola,Kreiger,Male,36,Katlynn view,Vermont,Bangladesh\n" +
                "Mr Rodolfo,Balistreri,Male,32,Crooks ton,Georgia,Bangladesh\n" +
                "Ms Juana,Champlin,Female,26,West Shanna,Georgia,Bangladesh\n";
        GuestListCreator guestListCreator = new GuestListCreator(data);
        String[] filters = {"country_Bangaladesh"};
        Guest[] guests = guestListCreator.getList();
        Representative representative = new Representative(guests);
        String expectedOutput = "Wrong input";
        assertTrue(expectedOutput.equals(representative.getRepresentation("fl",filters)));
    }
}