import PackageA.ClassA;
import PackageB.*;
/**
 * Write a description of class ClassC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassC
{
    public static void main(String[] args)
    {
        ClassA a = new ClassA(22);
        ClassA a1 = new ClassA(41);
        ClassB b = new ClassB(21);
        ClassB1 b1 = new ClassB1(33);
        
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a1.toStringForOtherObject(a));
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b1.getInfoFromOtherClass(b));
        // System.out.println(b.getAnotherNumberFromB1(b1)); //fails to compile
    }
}
