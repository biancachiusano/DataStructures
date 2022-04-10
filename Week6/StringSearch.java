import java.util.*;
import java.io.*;
public class StringSearch {

    public static int[] patternMatch(String text, String pattern) {
        // Return an array of indices representing the first indices of the matched
        // pattern in the String
        // You choose which algorithm you'd prefer to implement here (don't use brute-force)
        if(pattern.length() < 1)
          throw new IndexOutOfBoundsException("No pattern array found");
        //KMP algorithm
        int[] lsp = createLSP(pattern);
        System.out.println("LSP: " + Arrays.toString(lsp));
        ArrayList<Integer> a = new ArrayList<Integer>();
        int i=0;
        int j = 0;
        while(i != text.length()){

          while(i != text.length() && j != pattern.length()  && pattern.charAt(j) == text.charAt(i)){
            j++;
            i++;
          }
          //Two/three possibilities
          if(j == pattern.length()){//There where no mismatches
            j = lsp[pattern.length()-1];//a match is found until index [pattern.length()-1]
            a.add(i-(pattern.length()));
          }else if(j != 0){//There are mismatches on a character that is not the 1st
              j = lsp[j-1]; //Go to the lsp of the char before the one that does not match
          } else{//There are mismatches on the 1st character
            i++;
          }
        }

        int[] indices = new int[a.size()];
        for(int k = 0; k < a.size(); k++){
          indices[k] = a.get(k);
        }

        // If the pattern does not exist in the string, return an empty array
        return indices;
    }

    public static int[] createLSP(String pattern){
      int[] lsp = new int[pattern.length()];
      lsp[0] = 0;
      int value = 0;
      for(int i = 1; i < pattern.length(); i++){
        int temp = lsp[i-1];
        if(pattern.charAt(temp) == pattern.charAt(i)){
          value++;
          lsp[i] = value;
        }
        else{
          value = 0;
        }
      }
      return lsp;
    }

    /*public static void main(String[] args){
      StringSearch s = new StringSearch();
      System.out.println(Arrays.toString(s.patternMatch("AATTAAAGCGGCTGCACTGCTGTAAGGACGATTACGGAGTGGGCGGCCTG", "AT")));
    }*/
}
