package common;

public class StartTree
{
   final static int NUMBER_OF_STEPS = 8;

   public static void main(String[] args)
   {
      TFA tfa = new TFA();

      for (int i = 1; i < NUMBER_OF_STEPS; i++)
      {
         tfa.step();
      }

      System.out.println(tfa.toString());

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
   }
}
