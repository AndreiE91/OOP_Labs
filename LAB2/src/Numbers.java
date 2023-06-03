import java.math.BigInteger;

public class Numbers {
    public static void main(String[] args) {
        /*
        int myInt = 10;
        System.out.println(myInt);
        long myLong = 10L;
        System.out.println(myLong);
        int myHexa = 0X2A;
        System.out.println(myHexa);
        double myDouble = 3.14;
        System.out.println(myDouble);
        //float myFloat = 3.14; eroare
        float myFloat = 3.14f;
        System.out.println(myFloat); */

        double positiveInfinity = Double.POSITIVE_INFINITY;
        System.out.println(positiveInfinity);
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        System.out.println(negativeInfinity);
        System.out.println(positiveInfinity - negativeInfinity);
        BigInteger myBigInteger1 = new BigInteger("100");
        System.out.println(myBigInteger1);
        BigInteger myBigInteger2 = new BigInteger("50");
        BigInteger myBigIntegerSum = myBigInteger1.add(myBigInteger2);
        System.out.println(myBigIntegerSum);






    }
}
