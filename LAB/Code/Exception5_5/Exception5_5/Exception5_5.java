
/**
 * Create a three-level hierarchy of exceptions. 
 * Now create a base-class A with a method that throws an exception 
 * at the base of your hierarchy. 
 * Inherit B from A and override the method so it throws 
 * an exception at level two of your hierarchy. 
 * Repeat by inheriting class C from B. 
 * In main( ), create a C and upcast it to A, then call the method
 */
public class Exception5_5
{
  public static void main(String [] args)
  {
      C c = new C();
      A a = (A) c;
      try
      {
        a.sampleMethod(10);
      }
      catch (Exception e)
      {
          System.out.println("Caught an exception of class " + 
          e.getClass().getName() + " with message \"" + e.getMessage() + "\"");
      }
  }
}
