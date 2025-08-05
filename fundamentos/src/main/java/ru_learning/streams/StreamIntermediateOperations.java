package ru_learning.streams;

import ru_learning.util.BasicVideogame;
import ru_learning.util.Database;
import ru_learning.util.Review;
import ru_learning.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperations {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        //distinctOperator(videogames);
        //limitOperator(videogames);
        //skipOperator(videogames);
        //filterOperator(videogames);
        //mapOperator(videogames);
        //flatMapOperator(videogames);
        //mapVSFlatMapOperator(videogames);
        //peakOperator(videogames);
        //sortOperator(videogames);
        //takeWhileOperator(videogames);
        dropWhileOperator(videogames);



    }

    private static void distinctOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count());
    }

    private static void limitOperator(Stream<Videogame> stream){
        List<Videogame> result = stream.limit(5).toList();
        result.forEach(System.out::println);
    }

    private static void skipOperator(Stream<Videogame> stream){
        List<Videogame> result = stream.skip(15).toList();
        result.forEach(System.out::println);
    }

    private static void filterOperator(Stream<Videogame> stream){
        List<Videogame> result = stream
                .filter(v->v.getPrice() > 5.0)
                .filter(v-> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .toList();
        result.forEach(System.out::println);
    }

    private static void mapOperator(Stream<Videogame> stream){
        List<BasicVideogame> basicVideogames = stream
                .map(v -> {
                    return BasicVideogame.builder()
                            .name(v.getName())
                            .price(v.getPrice())
                            .build();})
                .collect(Collectors.toList());


        List<String> titles = basicVideogames.stream()
                .map(v-> v.getName()).limit(5)
                        .collect(Collectors.toList());

        basicVideogames.forEach(System.out::println);
        titles.forEach(System.out::println);
    }

    private static void flatMapOperator(Stream<Videogame> stream){
        List<Review> result = stream
                .flatMap(v-> v.getReviews().stream())
                        .collect(Collectors.toList());

        result.forEach(v -> System.out.println("Score: "+ v.getScore()));
    }

    private static void mapVSFlatMapOperator(Stream<Videogame> stream){
        /*
        Long totalReviews = stream.map(v -> v.getReviews().size()).sum()
                .count();
        */
        Long totalReviews = stream.flatMap(v -> v.getReviews().stream()).count();

        System.out.println(totalReviews);

    }

    private static void peakOperator(Stream<Videogame> stream){

        //stream.peek(System.out::println).collect(Collectors.toList());

        stream.peek(v -> v.setName("")).forEach(System.out::println);

    }

    private static void sortOperator(Stream<Videogame> stream){
        List<Videogame> sortedVideogames = stream
                .sorted(Comparator.comparing((Videogame v) -> v.getReviews().size()).reversed())
                .collect(Collectors.toList());
        sortedVideogames.forEach(System.out::println);
    }


    private static void takeWhileOperator(Stream<Videogame> stream){
        List<Videogame> videogames = stream
                .sorted(Comparator.comparing(v-> v.getName()))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        videogames.forEach(System.out::println);
    }

    private static void dropWhileOperator(Stream<Videogame> stream){
        List<Videogame> videogames = stream
                .sorted(Comparator.comparing(v-> v.getName()))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        videogames.forEach(System.out::println);
    }
}
