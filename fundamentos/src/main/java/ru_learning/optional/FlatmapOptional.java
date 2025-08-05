package ru_learning.optional;

import ru_learning.util.Movie;

import java.util.Optional;

public class FlatmapOptional {

    public static void main(String[] args) {

        Movie movie = new Movie("the nun", 20.42);
        Optional<Movie> movieOpt = Optional.of(movie);

        String name = movieOpt.flatMap(Movie::getName).orElse("Unknown");
        System.out.println(name);
    }
}
