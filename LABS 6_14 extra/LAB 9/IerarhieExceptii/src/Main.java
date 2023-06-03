public class Main {
    public static void main(String[] args) {
        A a = new C();
        try {
            a.myMethod();
        } catch(MyException1 e) {
            System.out.println("Caught MyException1");
        }
    }
}
