package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringJoiner;

import enums.Symbol;
import tree.Floor;
import tree.Leaf;

/** A fractal algorithm shows prime number patterning.
 * 
 * @author heeren Heeren, B. (2025). A fractal algorithm shows prime number
 *         patterning. Zenodo. https://doi.org/10.5281/zenodo.16829092
 *         
 * Tree Factory Automaton TFA
 * This produces the L-Tree as a data structure.
 */
public class TFA
{
   private final SFA sfa;
   private final Leaf rootLeaf;
   private final ArrayList<Floor> floors = new ArrayList<>();

   public TFA()
   {
      this.sfa = new SFA();
      rootLeaf = stepProducesRootLeaf();
   }

   private Leaf stepProducesRootLeaf()
   {
      sfa.step();
      floors.add(new Floor(sfa.getStepnumber(), sfa.getCPnPatternSize(), null));
      Leaf leaf = new Leaf(Symbol.L, 
                          null, 
                          sfa.getLeftmostElementOfWalksetCn(),
                          floors.getFirst());
      floors.getFirst().addLeaf(leaf);
      return leaf;
   }

   public void step()
   {
      sfa.step();
      
      if(!sfa.isBPnPrime())
      {
         return;
      }
      
      Floor previousFloor = floors.getLast();
      Floor floor = new Floor(sfa.getStepnumber(), sfa.getCPnPatternSize(), previousFloor);
      floors.add(floor);
      
      HashMap<Integer, Symbol> walksetsCnCPn = sfa.getWalksetCnCPn();
      
      Set<Integer> keyset = walksetsCnCPn.keySet();     
      for(int key : keyset)
      {
         Symbol cpn = walksetsCnCPn.get(key);
         if(Symbol.L.equals(cpn))
         {
            int headnumber = key;
            
            int headNumberOfPreviousLeaf = headnumber%previousFloor.getPatternSize();
            if(headNumberOfPreviousLeaf == 1)
            {
               headNumberOfPreviousLeaf = headNumberOfPreviousLeaf + previousFloor.getPatternSize();
            }
            else if(headNumberOfPreviousLeaf == 0)
            {
               headNumberOfPreviousLeaf = 2;
            }
            
            Leaf previousLeaf = previousFloor.getLeaf(headNumberOfPreviousLeaf);
           
            Leaf leaf = new Leaf(Symbol.L, 
                  previousLeaf, 
                  headnumber,
                  floor);
            
            floor.addLeaf(leaf);
         }
      }
   }

   public Leaf getRootLeaf()
   {
      return rootLeaf;
   }

   public String toString()
   {
      StringJoiner joiner = new StringJoiner("\n");
      for(Floor floor : floors)
      {
         joiner.add(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> floor start n = " + floor.getStepnumber());
         joiner.add("|                              pattern size = " + floor.getPatternSize());
         joiner.add(floor.toString());
         joiner.add(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> floor end n = " + floor.getStepnumber());
      }
      return joiner.toString();
   }
   
   public Floor getLastFloor()
   {
      return floors.getLast();
   }
}
