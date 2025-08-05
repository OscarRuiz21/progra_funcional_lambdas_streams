package ru_learning.paquete_function.interface_unaryoperator;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class InterfaceUnaryOperator {

    static Function<String, String> funToUpper = s-> s.toUpperCase();
    static Function<String, String> funToLower = String::toLowerCase;

    static UnaryOperator<String> toUpper = s-> s.toUpperCase();
    static UnaryOperator<String> toLower = String::toLowerCase;

    static UnaryOperator<Integer> toSquare = n-> n*n;
    static IntUnaryOperator toCube = n-> n*n*n;


    public static void main(String[] args) {

        String str = "Hola";
        Integer num = 5;

        System.out.println(funToUpper.apply(str));
        System.out.println(funToLower.apply(str));

        System.out.println(toUpper.apply(str));
        System.out.println(toLower.apply(str));

        System.out.println(toSquare.apply(num));
        System.out.println(toCube.applyAsInt(num));

    }
}
