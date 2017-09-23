package generalChallenges;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulation {

    public int firstMostFrequentInt(int[] userArray) {
        /**
         * Find the most frequent integer in an array.
         * returns the first mostFrequent integer
         */
        int mostFrequent = 0;
        int answer1 = userArray[0];

        // for every number in the userArray
        for (int numberA : userArray) {
            int timesFound = 0;
            // compare against every number in same userArray
            for (int numberB : userArray) {
                if (numberA == numberB) {
                    timesFound++;
                }
            }
            // if timesFound is larger
            // make mostFrequent = timesFound and answer1 = numberA
            if (timesFound > mostFrequent) {
                mostFrequent = timesFound;
                answer1 = numberA;
            }
        }
        return answer1;
    }


    public int[][] pairsThatMake10(int[] userArray) {
        /*
        * Find pairs in an integer array whose sum is equal to 10
        * returns a 2D array where each position is an array containing
        * two numbers summing up to 10
        */
        ArrayList<Integer> answers = new ArrayList<Integer>();

        for (int userNum : userArray) {
            for (int copyNum : userArray) {
                if ((userNum + copyNum) == 10) {
                    answers.add(userNum);
                    answers.add(copyNum);
                }
            }
        }
        return pairsHelper(answers);
    }


    public int[][] pairsHelper(ArrayList<Integer> userList) {
        /*
        * Input: an ArrayList of numbers
        * Output: a 2D array with each position an array of the next two numbers in userList
         */
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        int lengthy = userList.size();

        for (int i = 0; i < lengthy; i++) {
            if (i % 2 == 0) {
                evens.add(userList.get(i));
            } else {
                odds.add(userList.get(i));
            }
        }

        int[][] answers = new int[evens.size()][2];
        int index = 0;

        for (int[] arr : answers) {
            arr[0] = evens.get(index);
            arr[1] = odds.get(index);
            index++;
        }
        return answers;
    }


    /*
    remove duplicates from a sorted array of ints
     */
    public List<Integer> removeDuplicatesFromSorted(int[] numbers){
        List<Integer> solution = new ArrayList<>();
        solution.add(numbers[0]);

        for (int i = 1; i < numbers.length - 1; i++){
            if (numbers[i] != numbers[i-1]){
                solution.add(numbers[i]);
            }
        }
        return solution;
    }


    /*
    allow at most 2 duplicates
     */
    public List<Integer> leaveOneDuplicate(int[] numbers){
        List<Integer> solution = new ArrayList<>();

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i == numbers.length - 3) {
                if ((numbers[i] == numbers[i + 1]) ||
                        (numbers[i + 1] == numbers[i + 2]) ||
                        (numbers[i] != numbers[i+1] && numbers[i+1] != numbers[i + 2])){
                    solution.add(numbers[i]);
                    i++;
                    solution.add(numbers[i]);
                    i++;
                    if (numbers[i] != numbers[i-1]) {
                        solution.add(numbers[i]);
                    }
                }
            } else if (numbers[i] != numbers[i + 2]) {
                    solution.add(numbers[i]);
                }
        }
        // BLESS THIS MESS
        return solution;
    }

    /*
    move all zeros in an array to the end
     */
    public void moveZeros(int[] numbers){
        int noneZeros = 0;

        for (int num : numbers){
            if (num != 0){
                numbers[noneZeros] = num;
                noneZeros++;
            }
        }

        for (int z = noneZeros; z < numbers.length; z++){
            numbers[z] = 0;
        }
    }


    // MAIN
    public static void main(String[] args){
        ArrayManipulation man = new ArrayManipulation();

        int[] example = {1, 1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 9, 9};

        for (Integer num : man.leaveOneDuplicate(example)){
            System.out.print(num + " ");
        }

        System.out.println();

        for (Integer num : man.removeDuplicatesFromSorted(example)){
            System.out.print(num + " ");
        }

        System.out.println();

        int[] zeroTest = {1, 2, 0, 7, 0, 0, 4, 0, 0};
        man.moveZeros(zeroTest);
        for (int i : zeroTest){
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
