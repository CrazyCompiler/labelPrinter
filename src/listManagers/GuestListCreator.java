package listManagers;

import guest.*;
import guest.address.City;
import guest.address.Country;
import guest.address.State;

import java.util.ArrayList;

public class GuestListCreator {
    private String data;

    public GuestListCreator(String sampleCsvData) {
        data = sampleCsvData;
    }

    public ArrayList<Guest> getList() {
        String[] splitedDataByLine = data.split("\n");

        ArrayList<Guest> list = new ArrayList();
        for (int index=0;index<splitedDataByLine.length;index++) {
            String[] commaSeparatedArray = splitedDataByLine[index].split(",");
            Name guestName = new Name(commaSeparatedArray[0],commaSeparatedArray[1]);
            Gender guestGender = new Gender(commaSeparatedArray[2]);
            Age guestAge = new Age(Integer.parseInt(commaSeparatedArray[3]));
            City city = new City(commaSeparatedArray[4]);
            State state = new State(commaSeparatedArray[5]);
            Country guestCountry = new Country(commaSeparatedArray[6]);
            Guest guest = new Guest(guestName,guestAge,guestGender,city,state,guestCountry);
            list.add(guest);
        }
        return list;
    }
}
