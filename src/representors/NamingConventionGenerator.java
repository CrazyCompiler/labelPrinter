package representors;

import java.util.HashMap;

public class NamingConventionGenerator{
    private String convention;
    private HashMap nameElements = new HashMap();

    public NamingConventionGenerator(String convention) {
        this.convention = convention;
    }

    public String getRepresentation(String firstName, String lastName,String honorific) {
        this.nameElements.put("firstName",firstName);
        this.nameElements.put("lastName",lastName);
        this.nameElements.put("honorific",honorific);

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
