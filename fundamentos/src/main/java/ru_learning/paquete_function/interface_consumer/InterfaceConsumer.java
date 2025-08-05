package ru_learning.paquete_function.interface_consumer;

import java.util.*;

public class InterfaceConsumer {
    public static void main(String[] args) {
        Set<Integer> nums = Set.of(5,4,3,2,1);
        SortedSet<Integer> sortedNums = new TreeSet<>(nums);
        List<Integer> squares = new ArrayList<>();

        sortedNums.forEach(n -> squares.add(n*n));
        squares.forEach(System.out::println);

        Map<Boolean, String> map = Map.of(true, "Yes", false, "No");
        map.forEach((k,v) -> System.out.println(k + "-" + v));
    }
}
