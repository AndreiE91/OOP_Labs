
/**
 * Write a description of interface Numeric here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Numeric extends Comparable {
   public Numeric getZero();
   
   /**
    * Returns a copy of the object implementing numeric
    */
   public Numeric copy();
   
   /**
    * Adds two numeric objects and returns a new object holding the sum
    *      * 
    *      * @param  term   Numeric object add with
    *      * @return sum
    */
   public Numeric add(Numeric term);
   
   /**
    * Subtracts two numeric objects and returns a new object holding the difference
    *      * 
    *      * @param  term   term to subtract from this Numeric object
    *      * @return difference
    */
   public Numeric subtract(Numeric term);
   
   /**
    * Multiplies two numeric objects and returns a new object holding the product
    *      * 
    *      * @param  multiplier Numeric object to multiply with
    *      * @return product
    */
   /*package*/ Numeric multiply(Numeric multiplier);
   
   /**
    * Divides two numeric objects and returns a new object holding the quotient
    *      * 
    *      * @param  divisor Numeric object to divide to
    *      * @return quotient
    */
   public Numeric divide(Numeric divisor);
   
   }
