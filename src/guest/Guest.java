package guest;

import representors.NamingConventionGenerator;

import java.util.HashMap;

public class Guest {
    private Name name;
    private Age age;
    private Country country;
    private Gender gender;

    public Guest(Name name, Age age, Gender gender, Country country) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }


    public String getRepresentation(String representation, String[] filters) {
        HashMap guestEntities = new HashMap();
        guestEntities.put("age",this.age.toString());
        guestEntities.put("country",this.country.toString());
        String filterRepresentation = "";
        for (String filter : filters) {
            filterRepresentation += ", " + guestEntities.get(filter.split("_")[0]);
        }
        NamingConventionGenerator convention = new NamingConventionGenerator(representation);
        return this.gender.getHonorific()+name.getRepresentation(convention)+filterRepresentation;
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
}
