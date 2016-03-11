package guest;

import guest.address.City;
import guest.address.Country;
import guest.address.State;
import representors.EntityRepresentor;
import representors.NamingConventionGenerator;
import representors.TextRepresentors;

import java.util.HashMap;

public class Guest {
    private Name name;
    private Age age;
    private City city;
    private State state;
    private Country country;
    private Gender gender;
    private HashMap<String, TextRepresentors> guestEntities = new HashMap();

    public Guest(Name name, Age age, Gender gender, City city, State state, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    private void updateGuestEntries(){
        this.guestEntities.put("age",this.age);
        this.guestEntities.put("city",this.city);
        this.guestEntities.put("state",this.state);
        this.guestEntities.put("country",this.country);
    }

    private String horizontalLineCreator(int length,String[] borderSymbols){
        String line = borderSymbols[1];
        for (int index=0;index<length-2;index++){
            line += borderSymbols[0];
        }
        line += borderSymbols[1];
        return line;
    }

    public String getRepresentation(String nameRepresentationFormat, String entitiesRepresentationFormat,String[] borderSymbols) {
        updateGuestEntries();
        String representataion = "";
        NamingConventionGenerator namingConvention = new NamingConventionGenerator(nameRepresentationFormat);
        String nameRepresentation = name.getRepresentation(namingConvention,this.gender.getHonorific());

        EntityRepresentor entityRepresentor = new EntityRepresentor(entitiesRepresentationFormat);
        String entityRepresentation = entityRepresentor.getRepresentation(this.guestEntities) +"|";
        int lineLength = entityRepresentation.split("\n")[0].length();
        String horizontalLine = horizontalLineCreator(lineLength,borderSymbols);
        representataion = horizontalLine+"\n"+nameRepresentation+"\n"+horizontalLine+"\n"+entityRepresentation+"\n"+horizontalLine;
        return representataion;
    }

    public boolean isEligible(String[] filters) {
        HashMap <String,Testables>elements = new HashMap();
        elements.put("country",this.country);
        elements.put("age",this.age);
        boolean result = true;
        for (String filter : filters) {
            String element = filter.substring(0,filter.indexOf("_"));
            String data = filter.substring(filter.indexOf("_")+1);
            if((elements.get(element)).test(data) && result == true);
            result = (elements.get(element)).test(data);
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return super.equals(obj);
        Guest guest = (Guest) obj;

        return ((this.name.equals(guest.name))&&
                (this.gender.equals(guest.gender)) &&
                (this.age.equals(guest.age))
                && (this.country.equals(guest.country)));
    }
}
