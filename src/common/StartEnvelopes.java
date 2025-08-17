package common;

import java.math.BigDecimal;

import io.PrimeReader;
import tree.Floor;

public class StartEnvelopes
{
   final static int NUMBER_OF_STEPS = 14;

   public static void main(String[] args)
   {
      PrimeReader reader = new PrimeReader();
      //String primenumber = reader.readFromData();

      String primenumber = "82557089";//"19387777";
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
