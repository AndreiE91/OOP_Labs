import java.util.Scanner;

public class sumMultiples {

	/**
	 * Calculate the sum of the numbers which are multiples of 3 or 5 and also which are below limit 
	 * @param limit is the number where our while loop stops
	 * @param index is a counter which will be incremented until it reaches the limit 
	 * @return the value of the sum
	 */
	public static int sum(int limit)
	{
		int sum=0;
		int index=0;

		while( index < limit ) {
			if( index % 3 ==0 || index % 5 ==0 ) {
				sum+=index;
			}
			index++;
		}
		return sum;
	}

	public static void main(String[] args) {
		//System.out.println(sum(10));

		//System.out.println(sum(1000));

		/**
		 * Scanner allows us to read sth from the keyboard
		 * @param limitNumber is the number read from the keyboard
    	   @param limit will be the superior limit for the interval in which we want to find the sum
    	   @return we print the value of the sum
		 */
		//twist
		Scanner limitNumber = new Scanner(System.in);
		System.out.println("Select the limit number: ");
		int limit= limitNumber.nextInt();
		System.out.println(sum(limit));
		limitNumber.close();

		/*
        twist2 - HELP
        The overflow for an integer appears at 9,568,031
        But I discovered this only after I compiled my code a few (actually more than a few) times
        This is why I don't know the answer for long
		 */
	}
}
