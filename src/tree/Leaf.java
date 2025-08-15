package tree;

import enums.Symbol;

public class Leaf implements Comparable<Leaf>
{
   private Symbol symbol;
   private Leaf predecessor;
   private Integer previousLeafHeadnumber;
   private Integer headNumber;
   private Leaf successor;
   private Floor floor;

   Leaf()
   {

   }

   public Leaf(Symbol symbol, Leaf predecessor, Integer previousLeafHeadnumber,
         Integer headNumber, Floor floor)
   {
      super();
      this.symbol = symbol;
      this.predecessor = predecessor;
      this.previousLeafHeadnumber = previousLeafHeadnumber;
      this.headNumber = headNumber;
      this.floor = floor;
   }

   public Leaf getSuccessor()
   {
      return successor;
   }

   public void setSuccessor(Leaf successor)
   {
      this.successor = successor;
   }

   public Symbol getSymbol()
   {
      return symbol;
   }

   public Leaf getPredecessor()
   {
      return predecessor;
   }

   public Integer getStepnumber()
   {
      return previousLeafHeadnumber;
   }

   public Integer getHeadNumber()
   {
      return headNumber;
   }

   public Floor getFloor()
   {
      return floor;
   }

   @Override
   public int compareTo(Leaf o)
   {
      return headNumber.compareTo(o.getHeadNumber());
   }

   public void print()
   {
      System.out.println(" ------ Leaf start ------ ");
      System.out.println("" + previousLeafHeadnumber);
      System.out.println("");
      System.out.println("" + headNumber);
      System.out.println(" ------ Leaf end ------- ");
   }
}
