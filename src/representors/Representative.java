package representors;

import guest.Guest;

import java.util.ArrayList;
import java.util.HashMap;

public class Representative {
    ArrayList<Guest> guests;

    public Representative(ArrayList<Guest> guests) {
        this.guests = guests;
    }

    private String horizontalLineCreator(int length,String symbol){
        String line = "";
        for (int index=0;index<length;index++){
            line += symbol;
        }
        return line;
    }

    public String getRepresentation(String option, String[] filters) {
        String representation = "";
        HashMap namingConventions = new HashMap();
        namingConventions.put("-f", "firstName_lastName");
        namingConventions.put("-l", "lastName_,_firstName");

        for (int index = 0; index < this.guests.size(); index++) {
            if (namingConventions.containsKey(option)) {
//                representation += this.guests.get(index).getRepresentation((String)namingConventions.get(option),filters)+"\n";

            } else
                representation = "Wrong input";
        }
        return representation;
    }
}
