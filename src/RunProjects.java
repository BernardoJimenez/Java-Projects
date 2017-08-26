import algorithmChallenges.*;
import textBased.*;
import generalChallenges.*;
import sortingAlgorithms.*;
import java.util.*;
import mathBased.*;

public class RunProjects {
    // select which algorithm(s) to run
    public static void main(String[] args) {

        // Collatz's Conjecture
        CollatzConjecture.solveCollatz();

        System.out.println();

        // Fizz Buzz
        FizzBuzz.printFizzBuzz();

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

        // find pairs of ints in an array equaling 10
        int[] pairsArrayTest = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] pairedTenNums = arrayMan.pairsThatMake10(pairsArrayTest);
        for (int[] arr : pairedTenNums) {
            System.out.println(arr[0]);
            System.out.println(arr[1]);
            boolean tenTest = (arr[0] + arr[1] == 10);
            System.out.println(tenTest);
        }

        System.out.println();

        // sort sort an array of ints
        int[] testBubble = {2, 3, 1, 7, 4, 9, 0, 3, 5};
        BubbleSort.sort(testBubble);
        for (int bub : testBubble) {
            System.out.print(bub + " ");
        }

        System.out.println( );

        // find the Nth object in a LinkedList
        LinkedListManipulation linkMan = new LinkedListManipulation();
        LinkedList findNLink = new LinkedList();
        findNLink.add(1.5);
        findNLink.add(13);
        findNLink.add("dog");
        findNLink.add(200.9);
        findNLink.add(8);
        findNLink.add("cat");
        // Note: does not retain object class, must cast returned object
        System.out.println(linkMan.findNthInLinked(findNLink, 3));

        System.out.println();

        // BubbleSort an array of strings
        String[] animals = new String[]{"Cat", "Dog", "Hippo", "Lizard", "Owl"};
        // sort alphabetically
        Arrays.sort(animals);
        int sortAnimalsInt = 1;
        for (String animal : animals) {
            System.out.println("Animal " + sortAnimalsInt + " is " + animal);
            sortAnimalsInt++;
        }

        System.out.println();

        // BubbleSort an ArrayList of Strings
        List<String> fruits = new ArrayList<>();
        fruits.add("Pineapple");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Tomato");
        // sort alphabetically
        Collections.sort(fruits);
        int sortFruitInt = 1;
        for (String fruit : fruits) {
            System.out.println("Fruit " + sortFruitInt + " is " + fruit);
            sortFruitInt++;
        }

        System.out.println();

        // Implement square root from scratch
        System.out.println(MyMath.mySqrt(4));
        System.out.println(MyMath.mySqrt(36));
        System.out.println(MyMath.mySqrt(144));
        System.out.println(MyMath.mySqrt(84));
        System.out.println(MyMath.mySqrt(1));
        // known bugs: negative number should put into infinte loop
        // bad runtime

        System.out.println();

        // Implement multiplication
        System.out.println(MyMath.myMultiply(3, 8));
        System.out.println(MyMath.myMultiply(34, 7));
        System.out.println(MyMath.myMultiply(2, 0));
        System.out.println(MyMath.myMultiply(0, 3));
        System.out.println(MyMath.myMultiply(1, 100));
        // does not correctly output with negatives

        System.out.println();

        // Print Fibonacci sequence
        FibonacciSequence.printFibonacci(25);


     // end of main
    }
    // outside main
}
