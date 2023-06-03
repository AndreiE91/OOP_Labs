package library;

 
import java.util.Random;
/**
 * Write a description of class Useful here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Useful
{
    private static String vowels="aeiouy";
    private static String consonants="bcdfghjklmnpqrstvwxz";
    // instance variables - replace the example below with your own
    private static Random gen=new Random();
    public static final String[] generateBookInfo()
    {
        String[] result = new String[5];
        result[0] = generateISBN();
        result[1] = generateText(35);
        result[2] = generateText(45);
        result[3] = Integer.toString(1900 + gen.nextInt(116));
        result[4] = generateText(30);
        return result;
    }

    private static final String generateISBN()
    {
        return Long.toString(1000000000000L + gen.nextInt(Integer.MAX_VALUE));
    }

    private static final String generateText(int len)
    {
        int spacesIndex[] = new int[1 + gen.nextInt(3)];
        spacesIndex[0] = 4 + gen.nextInt(len/3);
        for (int i = 1; i < spacesIndex.length; i++)
            spacesIndex[i] = spacesIndex[i-1] + gen.nextInt(len - 5);
        StringBuffer text = new StringBuffer(len);
        char c =((gen.nextInt()%2 == 1)? vowels.charAt(gen.nextInt(vowels.length())):
            consonants.charAt(gen.nextInt(consonants.length())));
        text.append(Character.toUpperCase(c));
        loop:
        for (int i=1; i < len; i++)
        {
            boolean capitalize = false;
            for (int j=0; j < spacesIndex.length; j++)
            {
                if (i == spacesIndex[j])
                {
                    text.append(' ');
                    continue loop;
                }
                if (i - 1 == spacesIndex[j])
                    capitalize = true;
                if (i > j)
                    break;
            }
            text.append((gen.nextInt()%2 == 1)? vowels.charAt(gen.nextInt(vowels.length())):
                consonants.charAt(gen.nextInt(consonants.length())));        
            if (capitalize)
            {
                c = text.charAt(i);
                text.setCharAt(i, Character.toUpperCase(c));
            }
        }
        return text.toString();
    }
    public static final String [] generateRoomInfo()
    {
        String[] result = new String[2];
        result[0] = Integer.toString(1000 + gen.nextInt(8999));
        result[1] = Integer.toString(1 + gen.nextInt(9));
        return result;
    }
}
