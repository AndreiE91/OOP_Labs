import java.util.Scanner;

public class ScannerIntroduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("My name is " + name);
        int age = scanner.nextInt();
        System.out.println("My age is " + age);
        scanner.close();
    }
}
