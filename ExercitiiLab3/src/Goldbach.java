import java.util.Scanner;

import static java.lang.Math.*;

public class Goldbach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range_high, range_low;
        do {
            System.out.println("Please input range low");
            range_low = scanner.nextInt();
            System.out.println("Please input range high");
            range_high = scanner.nextInt();
        } while (range_high <= range_low);

        for (int i = range_low; i <= range_high; ++i) {
            if (belongsGoldach(i)) {
                boolean foundSum = false;
                int x = 0, y = 0, j = 0, k = i;
                while (!foundSum) {
                    if (getNextPrime(j) + getNextPrime(k) == i) {
                        x = j;
                        y = k;
                        foundSum = true;
                    }
                    ++j;
                    --k;
                }
                System.out.println(i + " belongs to Goldach's conjecture and it is the sum of " + x + " and " + y);
            } else {
                System.out.println(i + " does not belong to Goldach's conjecture");
            }
        }

        scanner.close();
    }

    static int getNextPrime(int number) {
        while (true) {
            if (isPrime(number))
                return number;
            ++number;
        }
    }

    static boolean isPrime(int number) {
        int nrDivisors = 0;
        if (number == 0) return false;
        if (number == 2 || number == 3) return true;
        for (int i = number; i >= (int) sqrt(number); --i) {
            if (number % i == 0) {
                ++nrDivisors;
            }
            if (nrDivisors > 1)
                return false;
        }
        return true;
    }

    static boolean belongsGoldach(int number) {
        if (number < 2 || number % 2 == 1) return false;
        return true;
    }
}

