import java.io.*;
import java.util.*;
public class StringCount {

int track;
    public StringCount() {
      track = 0; //initializing the count tacker
    }

    public int count(String s, char c, int i) {
      /*Check that i is not less than 0 and
      if i is than the string's length is greater than the String's length
      0 will be returned
      */

      if(i < 0)
        throw new IllegalArgumentException("Index i out of bounds for String s");

      if(i == s.length()){ //base case
        int result = track;
        track = 0;
        return result;
      }

      if(s.charAt(i) == c) //comparing the current character to the one that we want to find
          track++; //if found, the count increases
      i = i +1;
      return count(s, c, i); //recursive calls to check other characters
    }

    /*public static void main(String[] args){
      StringCount trial = new StringCount();
      System.out.println(trial.count("aeabee", 'e', 0));
      System.out.println(trial.count("aeabee", 'd', 0));
    }*/

}
