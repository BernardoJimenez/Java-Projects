import algorithmChallenges.*;
import textBased.*;
import generalChallenges.*;

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
        int[] thisIsOnlyATest = {2, 3, 5, 7, 5, 7, 3, 5, 6, 8, 5, 8, 1, 5};
        ArrayManipulation arrayMan = new ArrayManipulation();
        int intty = arrayMan.firstMostFrequentInt(thisIsOnlyATest);
        System.out.println(intty);
    }
    // outside main
}
