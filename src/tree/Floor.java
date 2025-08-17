package tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class Floor
{
   private final HashMap<String, Leaf> leafs;
   private final int stepnumber;
   private final int patternSize;

   public Floor(int stepnumber, int patternSize)
   {
      this.stepnumber = stepnumber;
      this.patternSize = patternSize;
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

   public String toString()
   {
      StringJoiner joiner = new StringJoiner("\n");
      ArrayList<Leaf> sortedLeafs = new ArrayList<>(leafs.values());
      sortedLeafs.sort(null);
      for (Leaf leaf : sortedLeafs)
      {
         joiner.add(leaf.toString());
      }
      return joiner.toString();
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
