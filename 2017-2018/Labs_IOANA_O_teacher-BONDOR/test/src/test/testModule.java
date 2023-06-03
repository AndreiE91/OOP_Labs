package test;

import java.math.BigInteger;
import java.util.Scanner;

public class testModule {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Give the value of i: ");
		int i=in.nextInt();
		BigInteger x,y;
		x=new BigInteger("2");
		y=x.pow(i-1);
		System.out.println("2^i = "+y);
		
		// TODO Auto-generated method stub
		/*Test1 t=new Test1();
		t.setNumber(10);
		System.out.println(t.getNumber());
		t.increaseNumber(26);
		System.out.println(t.getNumber());
		System.out.println(15.0/2);
		System.out.println(15/2.0);
		*/
	
	}

}
