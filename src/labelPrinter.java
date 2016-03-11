import argumentSeparators.ArgumentSeparator;
import filters.Filter;
import guest.Guest;
import listManagers.GuestListCreator;
import representors.Representative;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class labelPrinter {
    public static void main(String[] args) throws IOException {
        ArgumentSeparator argumentSeperator = new ArgumentSeparator(args);
        String[] files = argumentSeperator.getFileNames();
        String option = argumentSeperator.getOption();
        String[] filters = argumentSeperator.getFilters();
        String data = "";

        for (int index = 0; index < files.length; index++) {
            File csvData = new File(files[index]);
            InputStream inputStream = new FileInputStream(csvData);
            int size = inputStream.available();
            for (int i = 0; i < size; i++)
                data += (char) inputStream.read();
        }
        GuestListCreator guestListCreator = new GuestListCreator(data);
        ArrayList<Guest> guests = guestListCreator.getList();
        Filter filter = new Filter(filters);
        ArrayList<Guest> filteredGuestList = filter.getFilteredList(guests);
        Representative representation = new Representative(filteredGuestList);
        System.out.println(representation.getRepresentation(option));
    }
}
