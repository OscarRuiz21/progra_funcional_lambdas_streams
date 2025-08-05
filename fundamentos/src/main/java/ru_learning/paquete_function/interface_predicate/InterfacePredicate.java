package ru_learning.paquete_function.interface_predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class InterfacePredicate {

    static Predicate<Integer> isGreterThan100 = n -> n < 100 ;
    static Predicate<Integer> isLessThan10 = n -> n > 10 ;
    static Predicate<Integer> isBetween10And100 = isGreterThan100.and(isLessThan10).negate();

    public static void main(String[] args) {
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1,2,3,10,50,100,150,200));
        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(1,2,3,10,50,100,150,200));
        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(1,2,3,10,50,100,150,200));
        List<Integer> numbers4 = new ArrayList<>(Arrays.asList(1,2,3,10,50,100,150,200));


        numbers1.removeIf(n -> n>100);

        numbers2.removeIf(isGreterThan100);
        numbers3.removeIf(isLessThan10);
        numbers4.removeIf(isBetween10And100);

        System.out.println(numbers1);
        System.out.println("is greater than 100");
        System.out.println(numbers2);
        System.out.println("is less than 10");
        System.out.println(numbers3);
        System.out.println("is between 10 and 100");
        System.out.println(numbers4);
    }

}
