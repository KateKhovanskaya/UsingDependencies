package org.example;

import org.example.domain.Person;
import org.example.services.FileHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Екатерина", "хованская", 38);
        Person person1 = new Person("Екатерина", "хованская", 38);
        Person person2 = person;
        System.out.println(person.hashCode());
        System.out.println(person.toString());
        System.out.println(person.equals(person1));
        System.out.println(person.equals(person2));
        FileHandler fileHandler = new FileHandler();
        fileHandler.savePersonToFile(person, "person.json");
        Person loadingPerson = fileHandler.loadPersonFromFile("person.json");
        System.out.println(loadingPerson);
    }
}