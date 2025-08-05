package ru_learning;

public class FibonacciEx {

    public static void main(String[] args) {

        System.out.println(fibonacciWithMemo(10000));
    }

    private static int fibonacci(int n){
        if(n <= 1) return n;
        int result = (fibonacci(n-1) + fibonacci(n-2));
        return result;
    }

    private static int fibonacciWithMemo(int n){
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[memo.length-1];
    }
}


