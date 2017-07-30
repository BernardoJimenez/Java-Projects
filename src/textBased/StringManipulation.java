package textBased;

import java.util.Arrays;

public class StringManipulation {

    public String reverseString(String originalString) {
        /**
        * Input: a String
        * Output: the same string in reverse order
        */
        char[] originalArray = originalString.toCharArray();
        // make character array out of original String
        char[] reversedArray = new char[originalArray.length];
        // make a new array the same size as the original

        int reversedIndex;
        int normalIndex = 0;

        for (reversedIndex = (originalArray.length - 1); reversedIndex != -1; reversedIndex--) {
            reversedArray[normalIndex] = originalArray[reversedIndex];
            normalIndex++;
        }
        String reversedString = new String(reversedArray);
        return reversedString;
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


}
