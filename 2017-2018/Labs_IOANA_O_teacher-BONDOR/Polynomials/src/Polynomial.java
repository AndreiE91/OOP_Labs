import java.util.Scanner;

public class Polynomial {

	int orderOfPolynomial;
	int[] coefficientsOfPolynomial = new int[100];

	public void setOrderOfPolynomial(int orderOfPolynomial) {
		this.orderOfPolynomial = orderOfPolynomial;
	}

	public int getOrderOfPolynomial() {
		return orderOfPolynomial;
	}

	public void setCoefficientsOfPolynomial(int[] coefficientsOfPolynomial) {
		this.coefficientsOfPolynomial = coefficientsOfPolynomial;
	}

	public void setCoefficientsOfPolynomial(int index, int coefficient) {
		coefficientsOfPolynomial[index] = coefficient;
	}

	public int getCoefficientsOfPolynomial(int index) {
		return coefficientsOfPolynomial[index];
	}

	public int[] reverseArray(int[] array, int start, int end) {
		int temp;
		while (start < end) {
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		return array;
	}

	// TODO
	// public Polynom computeOperations (poly1, poly2, operations)

	public static void main(String[] args) {

		InputOutput r = new InputOutput();
		r.openTheFile();
		r.readTheFile();
		r.closeTheFile();

		// we declare two polynomials
		Polynomial polynomial1 = new Polynomial();
		polynomial1 = r.poly[0];
		polynomial1.reverseArray(polynomial1.coefficientsOfPolynomial, 0, polynomial1.orderOfPolynomial - 1);

		Polynomial polynomial2 = new Polynomial();
		polynomial2 = r.poly[1];
		polynomial2.reverseArray(polynomial2.coefficientsOfPolynomial, 0, polynomial2.orderOfPolynomial - 1);

		// TODO
		// mut in CO
		Functions functions = new Functions();

		// @multiplyPolynomials is multiplying two polynomials
		Polynomial multiplyPolynomials = new Polynomial();
		multiplyPolynomials = functions.multiplyPolynomials(polynomial1, polynomial2);
		functions.showPolynomials(multiplyPolynomials);

		// @addPolynomials is the sum of the two polynomials
		Polynomial addPolynomials = new Polynomial();
		addPolynomials = functions.addFunction(polynomial1, polynomial2);
		System.out.println("Sum of the two polynomials is");
		functions.showPolynomials(addPolynomials);

		// @subtractPolynomials is the difference of the two polynomials
		Polynomial subtractPolynomials = new Polynomial();
		subtractPolynomials = functions.subtractFunction(polynomial1, polynomial2);
		System.out.println("Substraction of the two polynomials is");
		functions.showPolynomials(subtractPolynomials);

		// @scalarMultiplyPolynomial represents the multiplication of a polynomial with
		// a scalar
		Scanner a = new Scanner(System.in);
		int scalar1 = a.nextInt();
		Polynomial scalarMultiplyPolynomial1 = new Polynomial();
		scalarMultiplyPolynomial1 = functions.scalarMultiplyFunction(scalar1, polynomial1);
		System.out.println("Scalar multiplicaton of the polynomial1 is");
		functions.showPolynomials(scalarMultiplyPolynomial1);

		Scanner b = new Scanner(System.in);
		int scalar2 = b.nextInt();
		Polynomial scalarMultiplyPolynomial2 = new Polynomial();
		scalarMultiplyPolynomial2 = functions.scalarMultiplyFunction(scalar2, polynomial2);
		System.out.println("Scalar multiplicaton of the polynomial2 is");
		functions.showPolynomials(scalarMultiplyPolynomial2);

		// @evaluateFunction means that we evaluate the polynomials by a certain
		// variable
		Scanner x = new Scanner(System.in);
		int variable1 = x.nextInt();
		int evaluate1 = functions.evaluateFunction(variable1, polynomial1);
		System.out.println(evaluate1);

		Scanner y = new Scanner(System.in);
		int variable2 = y.nextInt();
		int evaluate2 = functions.evaluateFunction(variable2, polynomial2);
		System.out.println(evaluate2);

		// close the Scanners
		a.close();
		b.close();

		x.close();
		y.close();

	}

}
