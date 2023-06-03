
public class Palindrome {

	/**
	 * check if a number is a palindrom or not
	 * @param number is the one that we are checking
	 * @param reversedNumber is the one that we form by reversing the original number
	 * @param clonedNumber is the original number of which we make a copy in order not to lose it
	 * @return true / false regarding of the answer
	 */
	
	public static boolean isPalindrom(int number) {

		int reversedNumber=0;
		int clonedNumber=number;

		while( number > 0) {
			reversedNumber= reversedNumber*10 + number % 10;
			number=number/10;
		}

		if(clonedNumber == reversedNumber) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {

		int number;

		
		//I'm using a break with a label in order to make my program get out of the both for loops
		//i,j are 99, 999,9999 one by one according to the twist that we are doing
		find_palindrom:
			for(int i=9999;i>=1000;i--)
			{
				for(int j=9999;j>=1000;j--) {
					number=i*j;
					if(isPalindrom(number)){
						System.out.println(number);
						break find_palindrom;
					}
				}
			}
	}
}
