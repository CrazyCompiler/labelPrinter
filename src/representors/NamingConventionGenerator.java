package representors;

import java.util.HashMap;

public class NamingConventionGenerator{
    private String convention;


    public NamingConventionGenerator(String convention) {
        this.convention = convention;
    }

    public String getRepresentation(String firstName, String lastName) {
        HashMap nameElements = new HashMap();
        nameElements.put("firstName",firstName);
        nameElements.put("lastName",lastName);

        String representation = "";
        String[] conventionElements = this.convention.split("_");
        for (int index=0;index<conventionElements.length;index++){
            if(nameElements.containsKey(conventionElements[index]))
                representation += " "+nameElements.get(conventionElements[index]);
            else
                representation += conventionElements[index];
        }
        return representation;
    }
}
