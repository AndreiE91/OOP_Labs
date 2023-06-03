public class PB3 {
    public static void countConsonantsAndVowels(String input) {
        String lowerCaseInput = input.toLowerCase();
        int countConsonants = 0; int countVowels = 0;
        for(int i=0; i < lowerCaseInput.length(); ++i)
        {
            if(lowerCaseInput.charAt(i) >= 'a' && lowerCaseInput.charAt(i) <= 'z')
            {
                if("aeiou".contains(lowerCaseInput.charAt(i)+""))
                {
                    countVowels++;
                }
                else {
                    countConsonants++;
                }
            }
        }
        System.out.println("Avem " + countVowels + " consoane și " + countVowels + " vocale.");
    }

    public static void main(String[] args) {
        countConsonantsAndVowels("Ana are mereeyn9c34t%$TGFGDGdfgdfgdfgd");
    }
}
