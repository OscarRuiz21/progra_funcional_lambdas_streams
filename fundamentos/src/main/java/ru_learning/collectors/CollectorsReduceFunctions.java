package ru_learning.collectors;

import ru_learning.util.Database;
import ru_learning.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //avg(videogames);
        stats(videogames);
        //joining(videogames);
    }

    static void avg(Stream<Videogame> stream){
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        System.out.println("Average price: " + avg);
    }

    static void stats(Stream<Videogame> stream){
        IntSummaryStatistics stats = stream.collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        System.out.println("Total sold: " + stats.getCount());
        System.out.println("Total sold: " + stats.getSum());
        System.out.println("Average price: " + stats.getAverage());
        System.out.println("Max price: " + stats.getMax());
        System.out.println("Min price: " + stats.getMin());
    }

    static void joining(Stream<Videogame> stream){
        String string = stream.map(Videogame::toString).collect(Collectors.joining("\n"));
        System.out.println(string);
    }
}
