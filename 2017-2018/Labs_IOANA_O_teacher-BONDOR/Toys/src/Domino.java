
public class Domino extends Toy implements IMultiPiecesToy {

	private int numberOfPieces;

	public Domino(int price, toysType type, int numberOfPieces) {
		super(price, type);
		this.numberOfPieces = numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	public int getNumberOfPieces() {
		return numberOfPieces;
	}

	@Override
	public void countPieces() {
		if (this.numberOfPieces == 25) {
			System.out.println("We have here all the pieces");
		} else {
			System.out.println("We don't have all the pieces");
		}

	}

}
