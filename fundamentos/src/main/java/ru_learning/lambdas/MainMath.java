package ru_learning.lambdas;

public class MainMath {
    public static void main(String[] args) {
        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b) {
                return a-b;
            }
        };
        Math multiply = (a, b) -> a*b;

        Math divide = (a, b) -> {
            System.out.println("Division");
            return a / b;
        };

        System.out.println("Sum");
        System.out.println(substract.sum(10.0, 5.0));
        System.out.println("Substraction");
        System.out.println(substract.execute(10.0, 5.0));
        System.out.println("Multiplication");
        System.out.println(multiply.execute(10.0, 5.0));

        System.out.println(divide.execute(10.0, 5.0));

    }
}
