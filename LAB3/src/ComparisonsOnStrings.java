public class ComparisonsOnStrings {
    public static void main(String[] args) {
        //System.out.println((11 == 10)?"da":"nu");
        //== -> referinte
        // .equals() -> proprietati
        String name1 = "OOP";
        String name2 = "OO";
        name2 += "P"; //teoretic acelasi string
        String name3 = " OOP";
        //name1 += "P";
        String name4 = new String("OOP");

        if(name1.equals(name2))
            System.out.println("1-2 equal");
        else
            System.out.println("1-2 not equal");
        if(name1 == name2)
            System.out.println("1-2 ==");
        else
            System.out.println("1-2 not ==");
        if(name1 == name4)
            System.out.println("1-4 ==");
        else
            System.out.println("1-4 not ==");
    }
}
