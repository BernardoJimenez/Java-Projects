package textBased;

import java.util.Arrays;

public class StringManipulation {

    public String reverseString(String originalString) {
        char[] originalArray = originalString.toCharArray();
        // make character array out of original String
        char[] reversedArray = new char[originalArray.length];
        // make a new array the same size as the original

        int reversedIndex;
        int normalIndex = 0;

        /*
        for (char character: originalArray) {
            reversedArray[reversedIndex] = character;
            reversedIndex++;
        }
        */

        for (reversedIndex = (originalArray.length - 1); reversedIndex != -1; reversedIndex--) {
            reversedArray[normalIndex] = originalArray[reversedIndex];
            normalIndex++;
        }
        String reversedString = new String(reversedArray);
        return reversedString;
    }

    public boolean checkIfPalindrome(String userString) {
        String reversedString = reverseString(userString);
        // reverse user String, store it
        // System.out.println(userString);
        // System.out.println(reversedString);
        return userString.equals(reversedString);
        // return true or false
    }


}
