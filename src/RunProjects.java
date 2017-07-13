import algorithmChallenges.*;
import textBased.*;

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
    }
}
