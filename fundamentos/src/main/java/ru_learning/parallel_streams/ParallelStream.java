package ru_learning.parallel_streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {


    // -D java.ru_learning.util.concurrent.ForkJoinPool.common.parallelism=4
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5);

        numbers.parallelStream().forEach(n->{
            System.out.println(n + " - "+"Thread: "+Thread.currentThread().getName());
        });
    }
}
