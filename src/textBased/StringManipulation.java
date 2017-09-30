package textBased;
import java.util.*;
import java.lang.*;

public class StringManipulation {

    public String reverseString(String originalString) {
        /**
        * Input: a String
        * Output: the same string in reverse order
        */
        // ONE LINE
        return new StringBuilder(originalString).reverse().toString();
    }


    public boolean checkIfPalindrome(String userString) {
        /**
         * Input: a String
         * Output: boolean indicating whether the string is the same in reverse order
         */
        String reversedString = reverseString(userString);
        return userString.equals(reversedString);
        // return true or false
    }

    /*
    calculate number of swaps needed to make the two strings anagrams of each other
     */
    public int numberOfSwapsNeeded(String first, String second){
        int[] letterCounts = new int[26]; // array of zeroes
        // indices represent letter in the alphabet
        int swapsNeeded = 0;

        for (char c : first.toCharArray()){
            letterCounts[c - 'a']++; // to that index
            // calculates to a number between 0 and 25
        }

        for (char c : second.toCharArray()){
            letterCounts[c - 'a']--; // subtract from that index
        }

        char letter = 'a';

        for (int count : letterCounts){
            if (count != 0) {
                System.out.println(letter + " is swapped " + Math.abs(count) + " time(s).");
            }
            swapsNeeded += Math.abs(count);
            letter++;
        }
        return swapsNeeded;
    }


    // MAIN
    public static void main(String[] args){
        StringManipulation manny = new StringManipulation();

        System.out.println(manny.checkIfPalindrome("dog"));
        System.out.println(manny.checkIfPalindrome("racecar") + "\n");

        System.out.println("Original: abcdef, Reversed: " + manny.reverseString("abcdef") + "\n");

        System.out.println(manny.numberOfSwapsNeeded("ccbbcca", "aaaacbb"));

    }
}
