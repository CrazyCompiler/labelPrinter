package representors;

import guest.Guest;

import java.util.HashMap;

public class Representative {
    private Guest[] guests;

    public Representative(Guest[] guests) {
        this.guests = guests;
    }

    public String getRepresentation(String option, String[] filters) {
        String representation = "";
        HashMap namingConventions = new HashMap();
        for (int index = 0; index < this.guests.length; index++) {
            namingConventions.put("-f", "firstName_lastName");
            namingConventions.put("-l", "lastName_,_firstName");

            if (namingConventions.containsKey(option)) {
                representation += this.guests[index].getRepresentation((String)namingConventions.get(option),filters)+"\n";
            } else
                representation = "Wrong input";
        }
        return representation;
    }
}
