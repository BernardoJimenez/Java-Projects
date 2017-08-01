package generalChallenges;

import java.util.ArrayList;

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
        * Input: an ArrayLit of numbers
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

}
