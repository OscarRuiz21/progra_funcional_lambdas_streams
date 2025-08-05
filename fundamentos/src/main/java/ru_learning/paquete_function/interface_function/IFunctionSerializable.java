package ru_learning.paquete_function.interface_function;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class IFunctionSerializable {

    static Function<Person, ByteArrayOutputStream> serializer = p ->{
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(inMemoryBytes)){

            outputStream.writeObject(p);
            outputStream.flush();


        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
      return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bais -> {
        try(ObjectInputStream inputStream = new ObjectInputStream(bais)){
            return (Person) inputStream.readObject();
        }catch(IOException | ClassNotFoundException ioe){
            throw new RuntimeException(ioe.getMessage());
        }
    };

    public static void main(String[] args) {
        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("Pedro", 20));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));
        System.out.println(objectSerialized);

        Person personDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));
        System.out.println(personDeserialized);
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


