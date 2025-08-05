package ru_learning.lambda_applications;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {

    public static void main(String[] args) {
        Path file = Path.of("src/main/resources/lambdas.txt");

        try(Stream<String> lines = Files.lines(file).onClose(() -> System.out.println("Buffer closed"))){

            lines.forEach(System.out::println);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
