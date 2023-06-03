package collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); //obiecte, nu tipuri primitive, de accea nu merge cu int
        HashMap<Integer, String> map2 = new HashMap<>(); //best practice e cu map in stanga, nu hashmap
        map.put(1, "OOP");
        map.put(2, "FA");
        map.put(3, "DB");
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        map.put(1, "OOOP");
        System.out.println(map);
        System.out.println(map.get(1));
        System.out.println("Contains value for key = 1 ? " + map.containsKey(1));
        System.out.println("Contains key for value = \"OOOP\" ? " + map.containsValue("OOOP"));
        for(Integer key : map.keySet()) {
            System.out.println(key);
        }
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-" +value);
        }
    }
}
