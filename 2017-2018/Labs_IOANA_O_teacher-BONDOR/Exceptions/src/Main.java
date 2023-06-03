import java.io.IOException;
import java.util.Arrays;

public class Main {

	// we can throw more than one exception at a time
	static int parse(String str) throws IOException, NumberFormatException {
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		/*
		 * Weather weather = null; 
		 * try { return; //int myInt = Integer.parseInt("a");
		 * //this won't be executed because it jumps to catch this error
		 * //weather.setDegrees(0); }
		 * 
		 * catch (NullPointerException e) // catch (Exception e) {
		 * System.out.println("why i can't print this?"); }
		 * 
		 * catch (NumberFormatException e) { System.out.println("whaat"); }
		 * 
		 * // no matter what happens in try&catch //this will always be executed 
		 * finally
		 * { System.out.println("This is pretty awesome"); //return; }
		 * 
		 * 
		 * //we can put in main's signature the throw exception //try { parse("a"); // }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * //e.printStackTrace(); //}
		 * 
		 *
		 * Weather weather2 = new Weather(-2); try { weather2.getDegrees(); } catch
		 * (FreezingException e) { e.printStackTrace(); }
		 */

		int[] numbers = { 0, 1, 2, 3, 4, 5 };
		try {
			/*
			 * for (int i = 0; i <= numbers.length; i++) { System.out.println(numbers[i]); }
			 */
			numbers[6] = 7;
		} catch (ArrayIndexOutOfBoundsException e) {
			numbers = Arrays.copyOf(numbers, 7);
			numbers[6] = 7;
			System.out.println(numbers[6]);
		}

	}
}