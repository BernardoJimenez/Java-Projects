package textBased;
import java.util.*;
import java.lang.*;

/*
Increments letters in a String based on times seen in original before
Example:       ababababab --> abbccddeef
What happened: First 'a' and 'b' are unchanged. Each successive instance is incremented by times
already seen in original. SO, the 2nd 'a' is incremented by 1 to 'b', and the 3rd 'a' is incremented
by 2 to 'c'.
 */
public class StringIncrementor {

    public String incrementBasedOnDuplicates(String str) {
        Map<Character, Integer> letters = new HashMap<>();
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            char currentLetter = str.charAt(i);
            Integer value = letters.get(currentLetter);

            if (value == null) {
                letters.put(currentLetter, 0);
                // value is number of DUPLICATES
            } else {
                value++;
                letters.put(currentLetter, value);
                currentLetter += value;
                sb.setCharAt(i, currentLetter);
            }
        }
        return sb.toString();
    }

    public static void main(String args[] ) throws Exception {
        StringIncrementor si = new StringIncrementor(); // yes!
        String x = "ababababab";
        String x1 = si.incrementBasedOnDuplicates(x);
        String y = "aaaaabbbbb";
        String y1 = si.incrementBasedOnDuplicates(y);
        String z = "abcabcabcabc";
        String z1 = si.incrementBasedOnDuplicates(z);

        System.out.println("Original: " + x + "\nExpected: abbdcedfeg\n" + "Actual:   " + x1 + "\n");
        System.out.println("Original: " + y + "\nExpected: abcdebcdef\n" + "Actual:   " + y1 + "\n");
        System.out.println("Original: " + z + "\nExpected: abcbcdcdedef\n" + "Actual:   " + z1 + "\n");
    }
}