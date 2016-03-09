package argumentSeparators;

public class ArgumentSeparator {
    private String[] arguments;

    public ArgumentSeparator(String[] arguments) {
        this.arguments = arguments;
    }

    private String[] push(String[] array, String push) {
        String[] longer = new String[array.length + 1];
        for (int index = 0; index < array.length; index++)
            longer[index] = array[index];
        longer[array.length] = push;
        return longer;
    }

    public String[] getFileNames() {
        String[] fileNames = new String[0];
        for (int index = 0; index < this.arguments.length; index++) {
            if (this.arguments[index].indexOf("-") == -1)
                fileNames = this.push(fileNames, arguments[index]);
        }
        return fileNames;
    }

    public String getOption() {
        String option = "";
        for (int index = 0; index < this.arguments.length; index++) {
            if (this.arguments[index].indexOf("-") == 0 && this.arguments[index].length() < 3)
                option = arguments[index];
        }
        return option;
    }

    public String[] getFilters() {
        String filters[] = new String[0];
        for (int index = 0; index < this.arguments.length; index++) {
            if (this.arguments[index].indexOf("-") == 0 && this.arguments[index].length() > 3)
                if (arguments[index].substring(1, 2).equals("c")) {
                    filters = this.push(filters,"country_"+arguments[index].substring(2));
                }
            if (arguments[index].substring(1, 2).equals("a")) {
                filters = this.push(filters,"age"+arguments[index].substring(2));
            }

        }
        return filters;
    }
}
