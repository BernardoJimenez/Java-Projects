import algorithmChallenges.*;
import textBased.*;
import generalChallenges.*;
import sortingAlgorithms.*;

public class RunProjects {
    // select which algorithm(s) to run
    public static void main(String[] args) {

        // Collatz's Conjecture
        CollatzConjecture cc = new CollatzConjecture();
        cc.solveCollatz();

        System.out.println();

        // Fizz Buzz
        FizzBuzz fb = new FizzBuzz();
        fb.printFizzBuzz();

        System.out.println();

        // check if Palindrome
        StringManipulation stringy = new StringManipulation();
        InputHelper stringyHelp = new InputHelper();
        boolean pString = stringy.checkIfPalindrome(stringyHelp.getUserInput(
                "Please enter a string to check if palindrome: "));
        System.out.println(pString);

        System.out.println();

        // print out first most frequent integer in an array
        int[] mostFreqTest = {2, 3, 5, 7, 5, 7, 3, 5, 6, 8, 5, 8, 1, 5};
        ArrayManipulation arrayMan = new ArrayManipulation();
        int mostFreq = arrayMan.firstMostFrequentInt(mostFreqTest);
        System.out.println(mostFreq + " is the most frequent integer.");

        System.out.println();

        int[] pairsArrayTest = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] pairedTenNums = arrayMan.pairsThatMake10(pairsArrayTest);
        for (int[] arr : pairedTenNums) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            boolean tenTest = (arr[0] + arr[1] == 10);
            System.out.println(tenTest);
        }

        System.out.println();

        int[] testBubble = {2, 3, 1, 7, 4, 9, 0, 3, 5};
        Sort sortty = new Sort();
        sortty.bubble(testBubble);
        for (int bub : testBubble) {
            System.out.print(bub + " ");
        }

     // end of main
    }
    // outside main
}
