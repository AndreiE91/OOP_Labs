import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CarShallow carShallow = new CarShallow("Dacia Păpuc", "white");

        PersonShallow[] persons = {
                new PersonShallow("Woana", "Onorfei", 20, carShallow),
                new PersonShallow("Laura", "Pop", 8, carShallow),
                new PersonShallow("Sonia", "Cibu", 25, carShallow),
                new PersonShallow("Traian", "Băsescu", 71, carShallow)
        };

        System.out.println("SHALLOW");
        PersonShallow personShallow1 = new PersonShallow("Woana", "Onorfei", 20, carShallow);
        PersonShallow personShallow2 = null;

        try {
            personShallow2 = (PersonShallow)personShallow1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SHALLOW:");
        System.out.println(personShallow1.getCar().getColor());
        System.out.println(personShallow2.getCar().getColor());
        personShallow2.getCar().setColor("red");
        System.out.println(personShallow1.getCar().getColor());
        System.out.println(personShallow2.getCar().getColor());

        System.out.println(personShallow1.getAge());
        System.out.println(personShallow2.getAge());
        personShallow2.setAge(100);
        System.out.println(personShallow1.getAge());
        System.out.println(personShallow2.getAge());

        System.out.println(personShallow1.getFirstName());
        System.out.println(personShallow2.getFirstName());
        personShallow2.setFirstName("Trump");
        System.out.println(personShallow1.getFirstName());
        System.out.println(personShallow2.getFirstName());

        CarDeep carDeep = new CarDeep("Dacia Păpuc", "white");


        PersonDeep personDeep1 = new PersonDeep("Woana", "Onorfei", 20, carDeep);
        PersonDeep personDeep2 = null;

        try {
            personDeep2 = (PersonDeep)personDeep1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("DEEP:");
        System.out.println(personDeep1.getCar().getColor());
        System.out.println(personDeep2.getCar().getColor());
        personDeep2.getCar().setColor("red");
        System.out.println(personDeep1.getCar().getColor());
        System.out.println(personDeep2.getCar().getColor());

        System.out.println(personDeep1.getAge());
        System.out.println(personDeep2.getAge());
        personDeep2.setAge(100);
        System.out.println(personDeep1.getAge());
        System.out.println(personDeep2.getAge());

        System.out.println(personDeep1.getFirstName());
        System.out.println(personDeep2.getFirstName());
        personDeep2.setFirstName("Trump");
        System.out.println(personDeep1.getFirstName());
        System.out.println(personDeep2.getFirstName());



        System.out.println("BEFORE:");
        for(PersonShallow person : persons) {
            System.out.println(person.getFirstName());
        }

        Arrays.sort(persons);
        System.out.println("AFTER");
        for(PersonShallow person : persons) {
            System.out.println(person.getFirstName());
        }
    }
}
