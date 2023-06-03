import java.util.Scanner;

public class ConsVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean wantsToRepeat;
        do {
            System.out.println("Please input a string:");
            String userInput = scanner.nextLine();
            System.out.println("The string you entered has " + vowelCount(userInput) + " vowels and " + consonantCount(userInput) + " consonants.");
            System.out.println("Wish to try again?(1/0)");
            int decision = scanner.nextInt();
            scanner.nextLine(); //flushes buffer
            if(decision == 1) wantsToRepeat = true;
            else wantsToRepeat = false;
        } while(wantsToRepeat);
    }

    static boolean isVowel(char input) {
        if(isLetter(input) && input < 97) {
            input += 32;
        }
        if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') return true;
        return false;
    }

    static boolean isLetter(char input) {
        if (input >= 97 && input <= 122 || input >= 65 && input <= 90) return true;
        return false;
    }

    static boolean isConsonant(char input) {
        if (!isVowel(input) && isLetter(input)) return true;
        return false;
    }

    static int vowelCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (isVowel(input.charAt(i)))
                ++count;
        }
        return count;
    }

    static int consonantCount(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (isConsonant(input.charAt(i)))
                ++count;
        }
        return count;
    }
}
