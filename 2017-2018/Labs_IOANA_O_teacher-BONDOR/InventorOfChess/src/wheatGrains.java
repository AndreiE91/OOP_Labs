
import java.math.BigInteger;
import java.util.Scanner;

public class wheatGrains {
	
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int i;
		i=in.nextInt();
		in.close();
		BigInteger rez=BigInteger.valueOf(2).pow(i-1);
		System.out.print("the rez is " + rez);
	}
}


