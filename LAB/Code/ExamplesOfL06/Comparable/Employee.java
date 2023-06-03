abstract class Employee implements Comparable
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
 
   public abstract double calculatePay();
}
