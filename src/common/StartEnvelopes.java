package common;

import java.math.BigDecimal;

//import io.PrimeReader;
import tree.Floor;

public class StartEnvelopes
{
   /**
    * for NUMBER_OF_STEPS = 17
    * 
    * TFA: patternsize 1 
    * TFA: patternsize 2 
    * TFA: patternsize 6 
    * TFA: patternsize 30 
    * TFA: patternsize 210 
    * TFA: patternsize 2310 
    * TFA: patternsize 30030 
    * TFA: patternsize 510510
    */
   final static int NUMBER_OF_STEPS = 14;

   public static void main(String[] args)
   {
      //PrimeReader reader = new PrimeReader();
      //String primenumber = reader.readFromData();

      String primenumber = "19387777";  // "82557089" is a semiprime!!! 
      //All numbers in L-columns (=envelopes) will be printed even if they are not prime
      //numbers from M-columns are detected as not prime.
      
      BigDecimal prime = new BigDecimal(primenumber);

      TFA tfa = new TFA();

      for (int i = 1; i < NUMBER_OF_STEPS; i++)
      {
         tfa.step();
      }

      Floor floor = tfa.getLastFloor();

      do
      {
         int patternSize = floor.getPatternSize();
         BigDecimal size = new BigDecimal(patternSize);
         if (size.compareTo(prime) == 1)
         {
            floor = floor.getPreviousFloor();
         }
         else
         {
            break;
         }
      } while (floor != null);

      System.out.println("StartEnvelope: prime number = " + primenumber);
      System.out
            .println("StartEnvelope: pattern size = " + floor.getPatternSize());
      System.out.println("");
      
      do
      {
         int a = floor.getPatternSize();
         int b = floor.getLeaf(prime).intValue();
         System.out.println("Envelope equation f(x) = " + a + "*x + " + b);
         floor = floor.getPreviousFloor();
      } while (floor != null);
   }

}
