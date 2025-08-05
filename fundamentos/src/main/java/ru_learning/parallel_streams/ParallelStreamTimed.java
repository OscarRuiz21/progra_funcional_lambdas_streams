package ru_learning.parallel_streams;

import java.util.stream.IntStream;

public class ParallelStreamTimed {
    public static void main(String[] args) {
        System.out.println("Sin paralelizar");
        long start = System.currentTimeMillis();
        System.out.println(start);

        IntStream.rangeClosed(1,200000000).reduce(0,Integer::sum);
        Long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("Tiempo transcurrido: " + (end - start) + " milisegundos");

        System.out.println("-------------------------------");
        System.out.println("Paralelizar");


        long startParallel = System.currentTimeMillis();
        System.out.println(start);

        IntStream.rangeClosed(1,200000000).parallel().reduce(0,Integer::sum);
        Long endParallel = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("Tiempo transcurrido: " + (endParallel - startParallel) + " milisegundos");

    }
}
