package listManagers;

import guest.*;

public class GuestListCreator {
    private String data;

    public GuestListCreator(String sampleCsvData) {
        data = sampleCsvData;
    }

    public Guest[] getList() {
        String[] splitedDataByLine = data.split("\n");

        Guest[] list = new Guest[splitedDataByLine.length];
        for (int index=0;index<splitedDataByLine.length;index++) {
            String[] commaSeparatedArray = splitedDataByLine[index].split(",");
            Name guestName = new Name(commaSeparatedArray[0],commaSeparatedArray[1]);
            Country guestCountry = new Country(commaSeparatedArray[6]);
            Gender guestGender = new Gender(commaSeparatedArray[2]);
            Age guestAge = new Age(Integer.parseInt(commaSeparatedArray[3]));
            Guest guest = new Guest(guestName,guestAge,guestGender,guestCountry);
            list[index] = guest;
        }
        return list;
    }
}
