import java.awt.Point;
import java.util.Scanner;

public class IO {
	public static String[] getCommand(){
		System.out.print("\n>> ");
		Scanner scanner = new Scanner(System.in);
		String cmd = scanner.nextLine();
		String[] splitted = cmd.split(" ");
		return splitted;
	}
}
