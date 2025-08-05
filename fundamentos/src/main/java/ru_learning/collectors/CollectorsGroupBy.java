package ru_learning.collectors;

import ru_learning.util.Console;
import ru_learning.util.Database;
import ru_learning.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBy {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Console, List<Videogame>> groupByConsole = videogames.collect(Collectors.groupingBy(Videogame::getConsole));

        groupByConsole.forEach((k, v) ->{
            System.out.println("Console = " + k);
            v.forEach(System.out::println);
            System.out.println("-------------------------------------");
        });
    }
}
