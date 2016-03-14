import argumentSeparators.ArgumentSeparator;
import filters.Filter;
import guest.Guest;
import listManagers.GuestListCreator;
import representors.Representative;

import java.io.IOException;
import java.util.ArrayList;

public class labelPrinter {
    public static void main(String[] args) throws IOException {
        ArgumentSeparator argumentSeperator = new ArgumentSeparator(args);
        String[] files = argumentSeperator.getFileNames();
        String option = argumentSeperator.getOption();
        String[] filters = argumentSeperator.getFilters();
        FileReader fileReader = new FileReader(files);
        String data = fileReader.getData();
        GuestListCreator guestListCreator = new GuestListCreator(data);
        ArrayList<Guest> guests = guestListCreator.getList();
        Filter filter = new Filter(filters);
        ArrayList<Guest> filteredGuestList = filter.getFilteredList(guests);
        Representative representation = new Representative(filteredGuestList);
        System.out.println(representation.getRepresentation(option));
    }
}
