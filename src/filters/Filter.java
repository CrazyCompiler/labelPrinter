package filters;

import guest.Guest;

import java.util.ArrayList;

public class Filter {
    private String[] filters;

    public Filter(String[] filters) {
        this.filters = filters;
    }

    public ArrayList<Guest> getFilteredList(ArrayList<Guest> guests) {
        ArrayList<Guest> filteredList = new ArrayList<Guest>();
        for (Guest guest : guests){
            if(guest.isEligible(this.filters))
                filteredList.add(guest);
        }
        return filteredList;
    }
}
