package comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ioana",31,5);
        Person person2 = new Person("Mihai",7,2);
        Person person3 = new Person("Anca",21,18);
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        System.out.println("COMPARARE FOLOSIND AGE");
        System.out.println("Before Sort using Comparable");
        for(Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCnp());
        }
        Collections.sort(persons);
        System.out.println();
        System.out.println("After Sort using Comparable");
        for(Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCnp());
        }
        System.out.println("COMPARARE FOLOSIND CNP");
        System.out.println("Before Sort using Comparator");
        for(Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCnp());
        }
// aici e diferenta
        PersonCnpComparator personCnpComparator = new PersonCnpComparator();
        Collections.sort(persons, personCnpComparator);
        System.out.println();
        System.out.println("After Sort using Comparator");
        for(Person person : persons) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getCnp());
        }
        // afisare folosind un Iterator
        Iterator<Person> it = persons.iterator();
        while (it.hasNext()) {
            Person aPerson = it.next(); // No downcast.
            System.out.println(aPerson.getName());
        }
    }
}
