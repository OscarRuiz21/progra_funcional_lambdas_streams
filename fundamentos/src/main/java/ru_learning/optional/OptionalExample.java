package ru_learning.optional;

import ru_learning.util.Database;
import ru_learning.util.Videogame;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<Videogame> gtaOpt = Optional.of(Database.videogames.get(5));
        System.out.println(gtaOpt);
        // No se deberia ocupar
        System.out.println(gtaOpt.get());

        System.out.println(gtaOpt.orElse(Database.videogames.get(1)));
        System.out.println(gtaOpt.orElseGet(() -> Database.videogames.get(1)));
        System.out.println(gtaOpt.orElseThrow(() -> new RuntimeException("VideoGame not found")));
    }
}
