import java.math.BigInteger;

public class BooleanAndCharacter {
    public static void main(String[] args) {
        System.out.println(10 == 10);
        BigInteger myBigInteger = new BigInteger("10");
        System.out.println(myBigInteger instanceof BigInteger);
        String string1 = "pepsi";
        char myChar = 'P';
        System.out.println(Character.isLowerCase(myChar));
        System.out.println(Character.isDigit(myChar));
        System.out.println(Character.toLowerCase(myChar));
        System.out.println(Character.isWhitespace(myChar));
    }
}
