package tree;

import java.util.StringJoiner;

import enums.Symbol;

public class Leaf implements Comparable<Leaf>
{
   private final Symbol symbol;
   private final Leaf predecessor;
   private final Integer previousLeafHeadnumber;
   private final Integer headNumber;
   private final Floor floor;

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

   public String toString()
   {
      StringJoiner joiner = new StringJoiner("\n");
      joiner.add(" ------ Leaf start ------ ");
      joiner.add("|  " + previousLeafHeadnumber);
      joiner.add("|  " + headNumber);
      joiner.add(" ------ Leaf end ------- ");
      return joiner.toString();
   }
}
