package paquete_function.interface_bipredicate;

import java.util.function.BiPredicate;

public class InterfaceBiPredicate {
    static BiPredicate<String, String> isEqual = (s1,s2) -> s1.equals(s2);

    static BiPredicate<String, String> myEqual = (s1,s2) -> s1.concat(s2).equals("HelloWorld");

    public static void main(String[] args) {
        System.out.println(isEqual.test("hola", "hola"));
        System.out.println(myEqual.test("Hello", "World"));
    }
}
