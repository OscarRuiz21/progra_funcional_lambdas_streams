package method_reference;

import java.util.function.BiPredicate;

public class ArbitraryMethodReference {
    public static void main(String[] args) {

        BiPredicate<String, String> equals1 = (s1,s2) -> s1.equals(s2);

        boolean isEqual1 = equals1.test("hola", "hola");
        System.out.println(isEqual1);

        BiPredicate<String, String> equals2 = String::equals;

        boolean isEqual2 = equals2.test("a", "a");
        boolean isEqual3 = equals2.test("a", "b");
        System.out.println(isEqual2);
        System.out.println(isEqual3);
    }
}
