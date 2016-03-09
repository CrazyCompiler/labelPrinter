package argumentSeparators;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ArgumentSeparatorTest {
    @Test
    public void test_getFileNames_for_one_file_name_provided_without_options() {
        String[] arguments = {"todo.txt"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String[] fileNames = {"todo.txt"};
        assertArrayEquals("failure - byte arrays not same", fileNames, args.getFileNames());
    }

    @Test
    public void test_getFileNames_for_more_than_one_file_name_provided_without_options() {
        String[] arguments = {"todo.txt", "demo.txt"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String[] fileNames = {"todo.txt", "demo.txt"};
        assertArrayEquals("failure - byte arrays not same", fileNames, args.getFileNames());
    }

    @Test
    public void test_getFileNames_for_one_file_name_provided_with_single_option() {
        String[] arguments = {"-f", "todo.txt"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String[] fileNames = {"todo.txt"};
        assertArrayEquals("failure - byte arrays not same", fileNames, args.getFileNames());
    }

    @Test
    public void test_getOption_for_one_file_name_and_one_option() {
        String[] arguments = {"-l", "todo.txt"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String option = "-l";
        assertEquals(option, args.getOption());
    }

    @Test
    public void test_getFilter_provides_filter_for_one_filter() {
        String[] arguments = {"-f", "todo.txt","-cBangaladesh"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String[] filters = {"country_Bangaladesh"};
        assertArrayEquals(filters, args.getFilters());
    }

    @Test
    public void test_getFilter_provides_filter_for_more_than_one_filter() {
        String[] arguments = {"-fl", "todo.txt","-cBangaladesh","-a_bellow_20"};
        ArgumentSeparator args = new ArgumentSeparator(arguments);
        String[] filters = {"country_Bangaladesh","age_bellow_20"};
        assertArrayEquals(filters, args.getFilters());
    }
}