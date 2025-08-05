package ru_learning.lambda_applications;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ThreadsAndLambdas {

    static Runnable printerSum = ()-> {
            long result = 0;
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 10000000; i++) {
                result += i;
            }
            System.out.println("Total " + result);
    };

    static Callable<Long> getSum = () -> {
        long result = 0;
        for (int i = 0; i < 10000000; i++) {
            result += i;
        }
        return result;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Thread.currentThread().getName());

        var exec = Executors.newSingleThreadExecutor();

        exec.submit(printerSum);

        var result = exec.submit(getSum);
        try {
            System.out.println("Result: " + result.get());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }


        exec.shutdown();


    }
}
