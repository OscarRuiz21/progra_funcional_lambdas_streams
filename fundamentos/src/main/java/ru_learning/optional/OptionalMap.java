package ru_learning.optional;

import ru_learning.util.Database;
import ru_learning.util.Videogame;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Optional<Videogame> gtaOpt = Optional.of(Database.videogames.get(5));
        String website =gtaOpt
                .map(videogame -> "The official website is " + videogame.getOfficialWebsite())
                .orElseThrow(() -> new RuntimeException("VideoGame not found"));
        System.out.println(website);
    }
}
