public class MethodOverloading {

    public static int test(int i, int j) {
        return i + j;
    }

    public static int test(int i, byte j) {
        return i + j;
    }


    public static void main(String[] args) {
        System.out.println(test(2, 3));
        System.out.println(test(2, Byte.MAX_VALUE));
    }
}
