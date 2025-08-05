package ru_learning.method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


// REFERENCIA A METODO MEDIANTE OBJETO

public class ObjectMethodReference {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);

        IntStream repeat = IntStream.range(1,11);
        repeat.forEach(numbers::add);
        numbers.forEach(System.out::println);
    }
}
