package ru_learning.paquete_function.interface_unaryoperator;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class InterfaceBinaryOperator {

    static BinaryOperator<Integer> rectangleArea = (n,m) -> n * m;

    public static void main(String[] args) {

        int a = 5;
        int b = 10;

        Integer result = rectangleArea.apply(a,b);
        System.out.println(result);

    }
}
