package ru_learning.paquete_function.interface_supplier;

import java.util.Random;
import java.util.function.Supplier;

public class InterfaceSupplier {

    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> myProductSupplier = () -> new MyProduct("Phone", randomInt.get().doubleValue());


    public static void main(String[] args) {

        System.out.println( randomInt.get());
        System.out.println( randomInt.get());
        System.out.println( randomInt.get());

        System.out.println(myProductSupplier.get());
        System.out.println(myProductSupplier.get());
        System.out.println(myProductSupplier.get());
    }
}

class MyProduct {
    private String name;
    private Double price;

    public MyProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
