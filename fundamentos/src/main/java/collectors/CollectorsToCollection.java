package collectors;

import util.Database;
import util.Videogame;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsToCollection {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();


        //Collection<Videogame> collection = streamToCollection(videogames, "list");

        //System.out.println(collection.getClass().getName());
        //collection.forEach(System.out::println);

        Map<String, Double> map = stringToMap(videogames);
        map.forEach((k, v) -> System.out.println(k + " - " + v));

    }

    static Collection<Videogame> streamToCollection(Stream<Videogame> stream, String type) {
        return (type.toUpperCase().equals("LIST")) ? stream.collect(Collectors.toList()) : stream.collect(Collectors.toSet());
    }

    static Map<String, Double> stringToMap(Stream<Videogame> stream) {
        return stream.distinct().collect(Collectors.toMap(Videogame::getName, Videogame::getPrice));
    }




}
