package tree;

import java.util.ArrayList;
import java.util.HashMap;

public class Floor
{
   private HashMap<String, Leaf> leafs;
   private int stepnumber;
   private int patternSize;

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

   public void printLeafs()
   {
      ArrayList<Leaf> sortedLeafs = new ArrayList<>(leafs.values());
      sortedLeafs.sort(null);
      for (Leaf leaf : sortedLeafs)
      {
         leaf.print();
      }
   }

}
