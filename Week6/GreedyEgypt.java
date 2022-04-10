import java.util.*;
class GreedyEgypt{

    public static List<Fraction> getEgyptFrac(Fraction fraction) {
        // Return an array of fractions that represent the Egyptian Fractions
        //Initializing the List
        LinkedList<Fraction> list = new LinkedList<Fraction>();

        Fraction newFrac = fraction;

          while(newFrac.numerator != 0){

            //Ceiling of the upsidedown fraction
            int ceiling = (int) Math.ceil(newFrac.denominator/(double)newFrac.numerator);
            Fraction newF = new Fraction(1, ceiling);
            System.out.println(ceiling);
            //add the first unit fraction to the List
            list.addLast(newF);

            //Subtract from the total
            if(list.getLast() != null){
              newFrac.numerator = (newFrac.numerator * list.getLast().denominator) - (newFrac.denominator); //Cause list.getLast().numerator should always be 1
              newFrac.denominator = newFrac.denominator * list.getLast().denominator;
            }
          }
        return list;
    }

    /*public static void main(String[] args){
      GreedyEgypt g = new GreedyEgypt();
      Fraction f = new Fraction(12, 13);
      List<Fraction> result = g.getEgyptFrac(f);
      System.out.println(result.toString());

    }*/
}
