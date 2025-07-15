package method_reference;

import java.util.UUID;
import java.util.function.Supplier;

public class StaticMethodReference {
    public static void main(String[] args) {
        Supplier<UUID> getToken = () -> UUID.randomUUID();
        System.out.println(getToken.get());

        Supplier<UUID> getToken2 = UUID::randomUUID;
        System.out.println(getToken2.get());
    }
}
