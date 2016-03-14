package representors;

import designs.Designs;
import designs.FirstDesign;
import guest.Guest;

import java.util.ArrayList;
import java.util.HashMap;

public class Representative {
    ArrayList<Guest> guests;

    public Representative(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    public String getRepresentation(String option) {
        String representation = "";
        HashMap namingConventions = new HashMap();
        namingConventions.put("-f", "honorific_firstName_lastName");
        namingConventions.put("-l", "honorific_lastName_,_firstName");
        String entityRepresentation = "space_city_delimiter_space_state_space_lineSeparator_space_country";
        Designs design = new FirstDesign();


        for (int index = 0; index < this.guests.size(); index++) {
            if (namingConventions.containsKey(option)) {
                representation += this.guests.get(index).getRepresentation((String)namingConventions.get(option),entityRepresentation,design)+"\n";
            } else
                representation = "Wrong input";
        }
        return representation;
    }
}
