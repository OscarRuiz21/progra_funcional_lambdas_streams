package ru_learning.streams;

import org.junit.jupiter.api.Test;
import ru_learning.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamFinalOperatorsTest {

    /**
     * Unit tests for the minOperator method in the StreamFinalOperators class.
     * The minOperator method finds and outputs the Videogame with the smallest "name"
     * lexicographically from the provided stream, using Comparator.comparing.
     */

    @Test
    void testMinOperatorWithMultipleGames() {
        // Arrange - create a stream of Videogame objects
        Stream<Videogame> videogames = Stream.of(
                Videogame.builder().name("Zelda").totalSold(1500).build(),
                Videogame.builder().name("Animal Crossing").totalSold(1200).build(),
                Videogame.builder().name("Mario Kart").totalSold(2000).build()
        );

        // Act - find the Videogame with the smallest name lexicographically
        Optional<Videogame> result = videogames.min(Comparator.comparing(Videogame::getName));

        // Assert - check the result
        assertTrue(result.isPresent());
        assertEquals("Animal Crossing", result.get().getName());
    }

    @Test
    void testMinOperatorWithSingleGame() {
        // Arrange
        Stream<Videogame> videogames = Stream.of(
                Videogame.builder().name("Halo").totalSold(800).build()
        );

        // Act
        Optional<Videogame> result = videogames.min(Comparator.comparing(Videogame::getName));

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Halo", result.get().getName());
    }

    @Test
    void testMinOperatorWithEmptyStream() {
        // Arrange
        Stream<Videogame> videogames = Stream.empty();

        // Act
        Optional<Videogame> result = videogames.min(Comparator.comparing(Videogame::getName));

        // Assert
        assertTrue(result.isEmpty());
    }
}