package ru_learning.paquete_function.interface_function;

import java.util.function.Function;

public class InterfaceFunction {

    static Function<Integer, Integer> multiply = x -> x * 10;
    static Function<Integer, Integer> sum = x -> x + 10;

    static Function<Integer, Integer> addThenMultiply = multiply.andThen(sum);
    static Function<Integer, Integer> composeMultiply = multiply.compose(sum);


    public static void main(String[] args) {
        System.out.println(multiply.apply(5));
        System.out.println(sum.apply(5));

        System.out.println(addThenMultiply.apply(5));
        System.out.println(composeMultiply.apply(5));
    }
}
