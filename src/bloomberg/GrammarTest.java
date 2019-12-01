package bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrammarTest {
    public static void main(String[] args) {

        // Practice for Arrays.asList
        String[] testArray = {"0", "1", "2", "3"};
        List<String> strings = Arrays.asList(testArray);
        for(String element: strings) System.out.println(element);
        System.out.println("After clear!");
    }
}
