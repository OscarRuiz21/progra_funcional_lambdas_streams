package ru_learning.collectors;

import ru_learning.util.Console;
import ru_learning.util.Database;
import ru_learning.util.Videogame;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupByAcumulators {
    public static void main(String[] args) {

        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Console, IntSummaryStatistics> totalSoldByConsole = videogames.collect(Collectors.groupingBy(
                Videogame::getConsole,
                Collectors.summarizingInt(Videogame::getTotalSold)
        ));

        totalSoldByConsole.forEach((k, v) -> {
            System.out.print("Console = " + k);
            System.out.println(" - total sold: " + v.getSum());
        });

    }
}
