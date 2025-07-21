package streams;

import org.w3c.dom.ls.LSOutput;
import util.Database;
import util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        //countOperator(videogames);

        //forEachOperator(videogames);

        //match(videogames);

        //findFirstOperator(videogames);

        //findAnyOperator(videogames);

        //reduceOperator(videogames);

        //maxOperator(videogames);

        minOperator(videogames);
    }

    static void countOperator(Stream<Videogame> stream) {
        System.out.println("Count: " + stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(System.out::println);
    }

    static void match(Stream<Videogame> stream) {

        //boolean r =  stream.anyMatch(v -> v.getTotalSold() > 1000);

        boolean r = stream.allMatch(v -> v.getTotalSold() > 1000);

        //boolean r =  stream.noneMatch(v -> v.getTotalSold() > 1000);

        System.out.println("Results: " + r);
    }

    static void findFirstOperator(Stream<Videogame> stream) {
        //stream.findFirst().ifPresent(System.out::println);

        Optional<Videogame> videogame = stream.filter(v -> v.getTotalSold() > 1000).findFirst();

        //Optional<Videogame> videogame = stream.findFirst();
        System.out.println("Result: " + videogame);
    }

    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> videogame = stream.findAny();
        System.out.println("Result: " + videogame);
    }

    static void reduceOperator(Stream<Videogame> stream) {

        Optional<Integer> result = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce((a,b) -> a+b);
                //.reduce(Integer::sum);

        System.out.println("Total discounted products sold: "+ result);

    }

    static void maxOperator(Stream<Videogame> stream) {

        Optional<Videogame> result = stream.max((a,b) -> a.getTotalSold().compareTo(b.getTotalSold()));
        System.out.println("Max: " + result.get().getName());
    }

    static void minOperator(Stream<Videogame> stream) {
        //Optional<Videogame> result = stream.min((a,b) -> a.getName().compareTo(b.getName()));
        Optional<Videogame> result = stream.min(Comparator.comparing(Videogame::getName));

        System.out.println("Min: " + result.get().getName());
    }
}
