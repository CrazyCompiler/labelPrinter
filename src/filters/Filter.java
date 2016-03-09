package filters;

import guest.Guest;

public class Filter {
    private String[] filters;

    public Filter(String[] filters) {
        this.filters = filters;
    }

    private Guest[] push(Guest[] array, Guest push) {
        Guest[] longer = new Guest[array.length + 1];
        for (int index = 0; index < array.length; index++)
            longer[index] = array[index];
        longer[array.length] = push;
        return longer;
    }

    public Guest[] getFilteredList(Guest[] guests) {
        Guest[] filteredList = new Guest[0];
        for (Guest guest : guests){
            if(guest.isEligible(this.filters))
                filteredList = this.push(filteredList,guest);
        }
        return filteredList;
    }
}
