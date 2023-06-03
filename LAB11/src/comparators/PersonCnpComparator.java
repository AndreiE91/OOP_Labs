package comparators;

import java.util.Comparator;

public class PersonCnpComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        //cnp
        if(p1.getCnp() < p2.getCnp()) {
            return -1;
        } else if(p1.getCnp() > p2.getCnp()){
            return 1;
        } else {
            return 0;
        }
    }
}
