package representors;

import guest.Guest;
import listManagers.GuestListCreator;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class RepresentativeTest {
    @Test
    public void testGetRepresentation_without_filters_first_name_last_name_convention() {
        String data = "Ola,Kreiger,Male,36,Katlynn view,Vermont,Romania\n" +
                "Rodolfo,Balistreri,Male,32,Crooks ton,Georgia,Bangladesh\n";
        GuestListCreator guestListCreator = new GuestListCreator(data);

        ArrayList<Guest> guests = guestListCreator.getList();

        Representative representative = new Representative(guests);
        String expectedOutput = "+-----------------------+\n" +
                "| Mr Ola Kreiger        |\n" +
                "+-----------------------+\n" +
                "| Katlynn view, Vermont |\n" +
                "| Romania               |\n" +
                "+-----------------------+\n" +
                "\n" +
                "+---------------------+\n" +
                "| Mr Rodolfo Balistreri|\n" +
                "+---------------------+\n" +
                "| Crooks ton, Georgia |\n" +
                "| Bangladesh          |\n" +
                "+---------------------+\n" +
                "\n";
        assertEquals(expectedOutput, representative.getRepresentation("-f"));
    }

    @Test
    public void testGetRepresentation_for_wrong_input() {
        String data = "Ola,Kreiger,Male,36,Katlynn view,Vermont,Romania\n" +
                "Rodolfo,Balistreri,Male,32,Crooks ton,Georgia,Bangladesh\n";
        GuestListCreator guestListCreator = new GuestListCreator(data);

        ArrayList<Guest> guests = guestListCreator.getList();

        Representative representative = new Representative(guests);
        String expectedOutput = "Wrong input";
        assertEquals(expectedOutput, representative.getRepresentation("-cc"));
    }

}