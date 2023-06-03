import javax.swing.*;

public class Casting {
    public static int getInt(String message) {
        int number = 0;
        try {
            number = Integer.parseInt(message);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Insert a valid integer!");
        }
        return number;
    }
    public static void main(String[] args) {
        /*
        String myString1 = "10";
        int myInt = Integer.parseInt(myString1);
        System.out.println(myString1);
        Integer myInteger = Integer.valueOf(myString1);
        System.out.println(myInteger);
        long myLong = Long.parseLong(myString1);
        System.out.println(myLong);
        //float și double tot la fel

        String myString2 = "OOP";
        //System.out.println(getInt(myString2));
        System.out.println(getInt("6"));
        System.out.println(getInt(myString1)); */

        //Integer myInteger = 7;
        //String myIntegerString = String.valueOf(5);
        //String myIntegerString2 = Integer.toString(myInteger);

        //System.out.println(myIntegerString2);
        int val = getInt1("Introduceti un intreg:");
        System.out.println(val);

    }

    public static int getInt1(String mess) {
        int val;
        while (true) { // itereaza in bucla pana cand se primeste un int valid
            String s = JOptionPane.showInputDialog(null, mess);
            try
            {
                val = Integer.parseInt(s);
                break; // iese din bucla cu un intreg valid >>>>>>>>>>>>>>>>>>>>>>
            }
            catch (NumberFormatException nx)
            {
                JOptionPane.showMessageDialog(null, "Introduce\u0163i un \u00eentreg valid");
            }
        }
        return val;
    }//end getInt

}
