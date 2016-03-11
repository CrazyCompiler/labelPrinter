package representors;

public class TextSeparator implements TextRepresentors{

    private String textSeperator;

    public TextSeparator(String textSeperator) {
        this.textSeperator = textSeperator;
    }

    public String toText() {
        return textSeperator;
    }
}
