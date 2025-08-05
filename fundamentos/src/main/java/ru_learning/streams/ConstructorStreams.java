package ru_learning.streams;

import ru_learning.util.Database;
import ru_learning.util.Videogame;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorStreams {

    public static void main(String[] args) {
        Stream<Videogame> myFirstStream = Database.videogames.stream();
        myFirstStream.forEach(System.out::println);

        System.out.println("-------------------------------------");

        Integer[] myArray = {1,2,3,4,5};
        Stream<Integer> mySecondStream = Stream.of(myArray);
        mySecondStream.forEach(System.out::println);

        System.out.println("-------------------------------------");

        Stream.of("Hello", "World").forEach(System.out::println);

        System.out.println("-------------------------------------");

        DoubleStream myDoubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        myDoubleStream.forEach(System.out::println);

    }

}
