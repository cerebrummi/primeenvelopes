package common;

public class StartTree
{
   final static int NUMBER_OF_STEPS = 5;

   public static void main(String[] args)
   {
      TFA tfa = new TFA();

      for (int i = 1; i < NUMBER_OF_STEPS; i++)
      {
         tfa.step();
      }

      tfa.printFloors();
   }
}
