package collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(); //abstract in stanga si concret in dreapta(List e abstract si ArrayList e concret)
        ArrayList<String> list2 = new ArrayList<String>();
        list.add("OOP");
        list.add("FA");
//        for(String element : list) {
//            System.out.println(element);
//        }
        list.add(1,"DB");
//        for(String element : list) {
//            System.out.println(element);
//        }
//        list.remove("DB");
//        for(String element : list) {
//            System.out.println(element);
//        }
//        System.out.println();
        list.set(1, "FA modified");
        for(String element : list) {
            System.out.println(element);
        }
        System.out.println(list.get(0));
        System.out.println("size=" + list.size());
        System.out.println(Collections.min(list));
        list.clear();
        System.out.println("size=" + list.size());
    }
}
