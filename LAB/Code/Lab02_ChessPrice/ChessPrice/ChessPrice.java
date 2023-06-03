import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Write a description of class ChessPrice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessPrice
{ 
    public static void main(String[] args)
    {
        BigInteger current = BigInteger.ONE;        
        BigInteger total = BigInteger.ONE;
        BigInteger two = new BigInteger("2");        
        for (int i = 2; i <= 64; ++i)
        {
            current = current.multiply(two);
            total = total.add(current);
        }
        System.out.println("Inventor asked for " + total + " grains of wheat");
        BigInteger oneGrainMilligrams = new BigInteger("64");
        BigDecimal grainWeight = new BigDecimal(oneGrainMilligrams, 9);
        BigDecimal totalTons = new BigDecimal(total);
        totalTons = totalTons.multiply(grainWeight);
        String s = totalTons.toString();
        int index = s.lastIndexOf('.');
        while (index - 3 > 0)
        {
            s = s.substring(0, index - 3) + "," + s.substring(index - 3);
            index -= 3;
        }
        System.out.println("Price for Chess Game was " + s + " tons of grain");
        System.out.println("FYI: Global wheat production in 2017 is now forecast at 750.1 million tonnes (FAO 05 Oct. 2017)");
    }
}
