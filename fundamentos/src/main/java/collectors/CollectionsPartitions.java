package collectors;

import util.Database;
import util.Videogame;

import java.awt.image.ImageProducer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsPartitions {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        /*
        Map<Boolean, List<Videogame>> partition = videogames.collect(Collectors.partitioningBy(Videogame::getIsDiscount));
        for(Map.Entry<Boolean, List<Videogame>> entry : partition.entrySet()){
            System.out.println("Is discount: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
         */

        Map<Boolean, List<Videogame>> partition = videogames.collect(Collectors.partitioningBy(
                videogame -> videogame.getPrice() > 15
        ));

        partition.forEach((k, v) -> {
            System.out.println("Greater than $15: " + k);
            v.forEach(System.out::println);
            System.out.println("-------------------------------------");
        });
    }


}
