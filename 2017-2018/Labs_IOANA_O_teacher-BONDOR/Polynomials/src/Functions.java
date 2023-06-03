public class Functions extends Polynomial {

	public int maximumSizeOfPoly(int sizeOfPolynomial1, int sizeOfPolynomial2) {

		if (sizeOfPolynomial1 > sizeOfPolynomial2)
			return sizeOfPolynomial1;
		else
			return sizeOfPolynomial2;
	}

	public int minimumSizeOfPoly(int sizeOfPolynomial1, int sizeOfPolynomial2) {

		if (sizeOfPolynomial1 < sizeOfPolynomial2)
			return sizeOfPolynomial1;
		else
			return sizeOfPolynomial2;
	}

	public void showPolynomials(Polynomial polynomial) {

		if (polynomial.coefficientsOfPolynomial[polynomial.orderOfPolynomial - 1] != 0)
			if (polynomial.coefficientsOfPolynomial[polynomial.orderOfPolynomial - 1] != 1)
				System.out.print(polynomial.coefficientsOfPolynomial[polynomial.orderOfPolynomial - 1] + "x^"
						+ (polynomial.orderOfPolynomial - 1));
			else
				System.out.print("x^" + (polynomial.orderOfPolynomial - 1));

		for (int i = polynomial.orderOfPolynomial - 2; i > 0; i--) {
			if (polynomial.coefficientsOfPolynomial[i] != 0) {
				if (polynomial.coefficientsOfPolynomial[i] > 0) {
					if (polynomial.coefficientsOfPolynomial[i] != 1)
						System.out.print(" + " + polynomial.coefficientsOfPolynomial[i] + "x^" + i);
					else
						System.out.print(" + x^" + i);
				} else {
					if (polynomial.coefficientsOfPolynomial[i] != -1)
						System.out.print(" " + polynomial.coefficientsOfPolynomial[i] + "x^" + i);
					else
						System.out.print(" - x^" + i);
				}
			}

		}
		if (polynomial.coefficientsOfPolynomial[0] != 0)
			if (polynomial.coefficientsOfPolynomial[0] < 0)
				System.out.println(" " + polynomial.coefficientsOfPolynomial[0]);
			else
				System.out.println(" + " + polynomial.coefficientsOfPolynomial[0]);
	}

	public Polynomial addFunction(Polynomial polynomial1, Polynomial polynomial2) {

		Polynomial addPoly = new Polynomial();

		int max = maximumSizeOfPoly(polynomial1.orderOfPolynomial, polynomial2.orderOfPolynomial);

		int min = minimumSizeOfPoly(polynomial1.orderOfPolynomial, polynomial2.orderOfPolynomial);

		addPoly.setOrderOfPolynomial(max);

		for (int i = 0; i < min; i++) {
			addPoly.setCoefficientsOfPolynomial(i,
					polynomial1.getCoefficientsOfPolynomial(i) + polynomial2.getCoefficientsOfPolynomial(i));
		}

		for (int i = min; i < max; i++) {
			if (polynomial1.orderOfPolynomial > polynomial2.orderOfPolynomial)
				addPoly.setCoefficientsOfPolynomial(i, polynomial1.getCoefficientsOfPolynomial(i));
			else
				addPoly.setCoefficientsOfPolynomial(i, polynomial2.getCoefficientsOfPolynomial(i));
		}

		return addPoly;

	}

	public Polynomial subtractFunction(Polynomial polynomial1, Polynomial polynomial2) {

		Polynomial subtractPoly = new Polynomial();

		int max = maximumSizeOfPoly(polynomial1.orderOfPolynomial, polynomial2.orderOfPolynomial);

		int min = minimumSizeOfPoly(polynomial1.orderOfPolynomial, polynomial2.orderOfPolynomial);

		subtractPoly.setOrderOfPolynomial(max);

		for (int i = 0; i < min; i++) {
			subtractPoly.setCoefficientsOfPolynomial(i,
					polynomial1.getCoefficientsOfPolynomial(i) - polynomial2.getCoefficientsOfPolynomial(i));
		}

		for (int i = min; i < max; i++) {
			if (polynomial1.orderOfPolynomial > polynomial2.orderOfPolynomial)
				subtractPoly.setCoefficientsOfPolynomial(i, polynomial1.getCoefficientsOfPolynomial(i));
			else
				subtractPoly.setCoefficientsOfPolynomial(i, polynomial2.getCoefficientsOfPolynomial(i));
		}

		return subtractPoly;

	}

	public Polynomial scalarMultiplyFunction(int scalar, Polynomial polynomial) {

		for (int i = 0; i < polynomial.orderOfPolynomial; i++) {
			polynomial.coefficientsOfPolynomial[i] *= scalar;
		}

		return polynomial;

	}

	public int evaluateFunction(int variable, Polynomial polynomial) {

		int sum = 0;
		for (int i = 0; i < polynomial.orderOfPolynomial; i++) {
			sum += polynomial.coefficientsOfPolynomial[i] * variable;
		}
		return sum;
	}

	public Polynomial multiplyPolynomials(Polynomial polynomial1, Polynomial polynomial2) {

		Polynomial multiplyPoly = new Polynomial();
		multiplyPoly.orderOfPolynomial = polynomial1.orderOfPolynomial + polynomial2.orderOfPolynomial - 1;

		for (int index = 0; index < multiplyPoly.orderOfPolynomial; index++)
			multiplyPoly.coefficientsOfPolynomial[index] = 0;

		for (int i = 0; i < polynomial1.orderOfPolynomial; i++)
			for (int j = 0; j < polynomial2.orderOfPolynomial; j++) {
				multiplyPoly.coefficientsOfPolynomial[i + j] += polynomial1.coefficientsOfPolynomial[i]
						* polynomial2.coefficientsOfPolynomial[j];
			}

		return multiplyPoly;
	}
}
