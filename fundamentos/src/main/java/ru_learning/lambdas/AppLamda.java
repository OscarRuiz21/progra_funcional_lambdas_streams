package ru_learning.lambdas;

import java.util.List;

public class AppLamda {
    public static void main(String[] args) {

        List<String> countries = List.of("Argentina", "Brazil", "Chile", "Colombia", "Mexico");

        for(String c : countries){
            System.out.print(c+", ");
        }

        System.out.println();
        for(int c = 0; c < countries.size(); c++){
            System.out.print(countries.get(c)+", ");
        }

        System.out.println("Lambda witg forEach");
        countries.forEach(c -> System.out.println(c.toUpperCase()));

        System.out.println("Referencia a metodo");
        countries.forEach(System.out::println);



    }

}
