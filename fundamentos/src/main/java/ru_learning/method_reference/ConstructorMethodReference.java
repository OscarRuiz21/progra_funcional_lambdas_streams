package ru_learning.method_reference;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class ConstructorMethodReference {

    public static void main(String[] args) {

        Supplier<MyObject> myObject1 = ()-> new MyObject();
        Supplier<MyObject> myObject2 = MyObject::new;

        System.out.println("My object 1");
        System.out.println(myObject1.get());

        System.out.println("My object 2");
        System.out.println(myObject2.get());
    }
}

class MyObject {
    private String string;
    private Integer num;

    MyObject(){
        this.string = UUID.randomUUID().toString();
        this.num = new Random().nextInt(1000);
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "string='" + string + '\'' +
                ", num=" + num +
                '}';
    }
}
