package lambda_applications;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambdas {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 1, 3, 5, 4);

        //numbers.sort((n1, n2) -> n1-n2);
        //numbers.sort(Integer::compare);
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);

        List<String> names = Arrays.asList("Max", "Peter", "John", "Anna");

        //names.sort(String::compareToIgnoreCase);
        //names.sort(String.CASE_INSENSITIVE_ORDER);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);


    }
}
