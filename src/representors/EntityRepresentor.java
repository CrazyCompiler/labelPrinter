package representors;

import java.util.HashMap;

public class EntityRepresentor {
    private String format;
    private HashMap<String,TextRepresentors> textSeparators = new HashMap();

    public EntityRepresentor(String format) {
        this.format = format;
        this.textSeparators.put("lineSeparator",new TextSeparator("\n"));
        this.textSeparators.put("delimiter",new TextSeparator(","));
        this.textSeparators.put("space",new TextSeparator(" "));
    }


    public String getRepresentation(HashMap<String,TextRepresentors> elements) {
        String[] splitedFormat = this.format.split("_");
        String representation = "";
        for (String formatElement : splitedFormat) {
            if (elements.containsKey(formatElement))
                representation += elements.get(formatElement).toText();
            else if(this.textSeparators.containsKey(formatElement))
                representation += this.textSeparators.get(formatElement).toText();
        }
        return representation;
    }
}
