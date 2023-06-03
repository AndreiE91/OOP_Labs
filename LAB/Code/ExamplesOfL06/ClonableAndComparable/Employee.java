abstract class Employee implements Cloneable, Comparable
 {
    // instance variables
    private String name;
    public Employee(String name) 
   {
       this.name = name;
   }
   public String getName() 
   {
       return name;
   }
   public int compareTo(Object other) 
   {
       Employee e = (Employee) other; 
       return name.compareTo(e.name); 
   }
   public Object clone() 
   {
        Cloneable theClone = new Employee(this.name);
        // Initialize theClone. No need here as String is the only variable and is immutable
        return theClone;
    }
   public abstract double calculatePay();
}
