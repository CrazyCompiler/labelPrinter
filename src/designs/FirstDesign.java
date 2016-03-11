package designs;

public class FirstDesign implements Designs {
    private String entityRepresentation = "space_city_delimiter_space_state_space_|_lineSeparator_|_space_country";

    private String horizontalLineCreator(int length, String[] borderSymbols) {
        String line = borderSymbols[1];
        for (int index = 0; index < length - 2; index++) {
            line += borderSymbols[0];
        }
        line += borderSymbols[1];
        return line;
    }

    public String getRepresentation(String namingFormat, String entityFormat) {
        String firstEntityLine = entityFormat.split("\n")[0];
        String secondEntityLine = entityFormat.split("\n")[1];

        String[] borderSymbols = {"-", "+"};
        String representation = "";
        int lineLength = entityFormat.split("\n")[0].length() + 1;

        if (lineLength < entityFormat.split("\n")[1].length())
            lineLength = entityFormat.split("\n")[1].length() + 1;

        String line = this.horizontalLineCreator(lineLength + 1, borderSymbols);
        String[] emptyBorders = {" ", ""};

        String lineOfSpaceForFirstEntities = this.horizontalLineCreator(lineLength - (firstEntityLine.length() - 1), emptyBorders);
        String lineOfSpaceForSecondEntities = this.horizontalLineCreator(lineLength - (secondEntityLine.length() - 1), emptyBorders);
        String lineOfSpaceForName = this.horizontalLineCreator(lineLength - (namingFormat.length()) + 1, emptyBorders);

        representation += line + "\n";
        representation += "|" + namingFormat + lineOfSpaceForName + "|" + "\n";
        representation += line + "\n";
        representation += "|" + firstEntityLine + lineOfSpaceForFirstEntities + "|" + "\n";
        representation += "|" + secondEntityLine + lineOfSpaceForSecondEntities + "|" + "\n";
        representation += line + "\n";

        return representation;
    }
}
