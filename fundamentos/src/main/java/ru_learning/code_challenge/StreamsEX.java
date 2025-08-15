package ru_learning.code_challenge;

import ru_learning.util.Console;
import ru_learning.util.Database;
import ru_learning.util.Review;
import ru_learning.util.Videogame;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class StreamsEX {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        //System.out.println("Exercise 1: " + exercise1(videogames));
        //System.out.println("Exercise 2: ");
        //exercise2(videogames).forEach(System.out::println);
        //System.out.println("Exercise 3: " + exercise3(videogames));
        //System.out.println("Exercise 4: ");
        //exercise4(videogames).forEach(System.out::println);
        System.out.println("Exercise 5: ");
        exercise5(videogames).forEach(System.out::println);
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        /*
        if (stream.filter(v -> v.getTotalSold() > 10).count()>0)
            return true;
        else return false;
        */
        return stream.anyMatch(v -> v.getTotalSold() > 10 && !v.getIsDiscount());

    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {

        return stream
                .distinct()
                .filter(videogame -> videogame.getConsole().equals(Console.XBOX))
                .peek(videogame -> System.out.println(videogame))
                .map(Videogame::getName);
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        return stream
                .limit(10)
                .max((a,b) -> b.getTotalSold().compareTo(a.getTotalSold()))
                .orElseThrow(NoSuchElementException::new);
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        return stream
                .flatMap(videogame -> videogame.getReviews().stream()
                        .map(review -> review.getComment()));

//        return stream
//                .flatMap(v -> v.getReviews().stream().map(Review::getComment));
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<String> exercise5(Stream<Videogame> stream) {
        return stream
                .sorted(Comparator.comparingDouble(Videogame::getPrice))
                .takeWhile(v -> v.getPrice() < 20.0)
                .map(Videogame::getName);
    }

}
