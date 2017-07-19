package generalChallenges;

public class ArrayManipulation {
    /**
     * > Find the most frequent integer in an array.
     * returns the first mostFrequent integer
     */

    public int firstMostFrequentInt(int[] userArray) {
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

}
