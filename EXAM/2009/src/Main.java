
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Math.floorMod(-1,4));

		
		Board board = new Board(); 
		board.printBoard();
		while(!board.gameOver()){
			board.inputComand();
			board.printBoard();
		}
		
		
	}

}
