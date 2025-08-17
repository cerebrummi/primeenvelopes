package tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Floor
{
   private HashMap<String, Leaf> leafs;
   private int stepnumber;
   private int patternSize;
   private Floor previousFloor;

   public Floor(int stepnumber, int patternSize, Floor previousFloor)
   {
      this.stepnumber = stepnumber;
      this.patternSize = patternSize;
      this.previousFloor = previousFloor;
      leafs = new HashMap<>();
   }

   public void addLeaf(Leaf leaf)
   {      
      leafs.putIfAbsent(leaf.getHeadNumber() + "_" + patternSize, leaf);
   }

   public Leaf getLeaf(int headnumber)
   {
      return leafs.get(headnumber + "_" + patternSize);
   }

   public int getStepnumber()
   {
      return stepnumber;
   }

   public int getPatternSize()
   {
      return patternSize;
   }

   public void printLeafs()
   {
      ArrayList<Leaf> sortedLeafs = new ArrayList<>(leafs.values());
      sortedLeafs.sort(null);
      for (Leaf leaf : sortedLeafs)
      {
         leaf.print();
      }
   }

   public Floor getPreviousFloor()
   {
      return previousFloor;
   }
   
   public Integer getLeaf(BigDecimal prime)
   {
      BigDecimal leafsPatternSize = new BigDecimal(patternSize);
      for(Leaf leaf : leafs.values())
      {
         BigDecimal leafHeadNumber = new BigDecimal(leaf.getHeadNumber());
         BigDecimal result = prime.subtract(leafHeadNumber).remainder(leafsPatternSize);
         if(BigDecimal.ZERO.equals(result))
         {
            return leaf.getHeadNumber();
         }
      }
      System.err.println("This is not a prime number.");
      System.exit(1);
      return null;
   }
}
