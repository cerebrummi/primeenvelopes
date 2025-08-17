package common;

public class StartFA
{
  final static int NUMBER_OF_STEPS = 8;
  
   public static void main(String[] args)
   {
      SFA sfa = new SFA();
      sfa.toString();
      
      for( int i = 0 ; i < NUMBER_OF_STEPS; i++)
      {
         System.out.println("========== step start ==========");
         sfa.step();
         System.out.println(sfa.toString());
         System.out.println("========== step end ===========");
      }
   }
}

