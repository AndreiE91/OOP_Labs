
public class fibonnaciSum {

	public static void main(String[] args) {
	
		/*
		 * calculate the Fibonnaci sum for even numbers
		 * @param first is the first from the sequence
		 * @param second is the second from the sequence
		 * @param next is the number which will keep forming in the while loop
		 * @return evenSum which is the answer
		 */
		
		/*
		first idea for the basic demand of the problem
		int first=1;
		int second=2;
		int next=0;
		int evenSum=2;
		while(next <= 4000000 ) {
			next=first+second;
			first=second;
			second=next;
			if(next % 2 == 0) {
				evenSum+=next;
			}
		}
		System.out.println(evenSum);
		*/
		
		
		/**
		 * same problem, different approach
		 * @param fibNumbers is an array of integers, in which will store the Fibonnaci numbers
		 * @return evenSum which is the answer
		 */
		
		//twist
		//idk if this is in O(n), but still
		int []fibNumbers = new int[10000000]; //HELP how large the array should be?
		fibNumbers[0]=1;
		fibNumbers[1]=2;
		int evenSum=2;
		for(int i=2; i<=fibNumbers.length; i++) {
			//form the new Fibonnaci number according to its rule
			fibNumbers[i]=fibNumbers[i-1]+fibNumbers[i-2]; 
			if(fibNumbers[i] > 4000000) {
				break;
			}
			if(fibNumbers[i] % 2 == 0) {
				evenSum+=fibNumbers[i];
			}
		}
		System.out.println(evenSum);
		
		//twist2 
		//HEEELP
		// O(log n)??
	}
}
