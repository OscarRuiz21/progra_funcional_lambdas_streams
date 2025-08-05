package ru_learning.paquete_function.interface_bifunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class InterfaceBiFunction {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);


        // Versión con lambda y metodo generico
        List<String> result = listCombiner(list1, list2, (l1, l2) -> l1 + l2);
        System.out.println(result);


        // Versión sin lambda: Clase anónima
        BiFunction<String, Integer, String> combiner2 = new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer i) {
                return s + "-" + i;
            }
        };
        List<String> result2 = listCombiner(list1,list2, combiner2);
        System.out.println(result2);


        // Versión sin lambda: Clase concreta que implementa BiFunction
        BiFunction<String, Integer, String> combiner3 = new Concatenador();
        List<String> result3 = listCombiner(list1, list2, combiner3);
        System.out.println(result3);


    }

    private static<T,U,R> List<R> listCombiner(
            List<T> list1,
            List<U>list2,
            BiFunction<T,U,R> combiner){
        // 1. List validation
        if(list1.size() != list2.size()){
            throw new IllegalArgumentException("Lists must have the same size");
        }
        // 2. Create result list
        List<R> result = new ArrayList<>();

        // 3. iteration and extracting i elements for each list.
        for(int i= 0; i<list1.size(); i++){
            T elem1 = list1.get(i);
            U elem2 = list2.get(i);
            R combinedResult = combiner.apply(elem1, elem2);
            result.add(combinedResult);
        }
        // 4. returning result
        return result;
    }

    private static class Concatenador implements BiFunction<String, Integer, String> {
        @Override
        public String apply(String s, Integer i) {
            return s + "_" + i;
        }
    }

}
