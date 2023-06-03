import com.sun.source.doctree.SeeTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int numberOfElfs = 5;
//        int[] packets = {4, 5, 2, 10, 57, 8, 10, 13};
//        System.out.println(minDiff(packets, numberOfElfs));
//        System.out.println(21 >> 3);
//        final Pegas p = new Pegas();
//        int x = 7;
//        Integer a = Integer.valueOf(x);
        //Class1 test = new Class2();
        //System.out.println(((Class2)test).str);
        //test.hello();
        //(new Class2()).hello();
        //A obj = new B(10);
        AA obj = new AA();
        obj.mesaj();
        Set<Double> exemplu = new HashSet<Double>();
    }
    //The code you provided gives the maximum difference. Say y = 5 and
    //        ix = {4, 5, 2, 10, 57, 8, 10, 13}. minDiff will be 49 and it should be 6

    public static int minDiff(int[] arr, int y) {
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        if (n < y) return 0;

        for (int i = 0; i <= n - y; i++) {
            int[] sub = Arrays.copyOfRange(arr, i, i + y);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < sub.length; j++) {
                max = Math.max(max, sub[j]);
                min = Math.min(min, sub[j]);
            }
            minDiff = Math.min(minDiff, max - min);
        }
        return minDiff;
    }



}
