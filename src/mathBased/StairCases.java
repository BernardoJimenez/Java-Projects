package mathBased;

public class StairCases {

    public static int countWaysNaive(int steps){
        if (steps < 0){
            return 0;
            // return 0 if no way of perfectly going up stairs using the
            // given path, OR there are no initial stairs
        } else if (steps == 0){
            return 1;
        }
        return countWaysNaive(steps - 1) + countWaysNaive(steps -2) +
                countWaysNaive(steps - 3);
        /*
        After leaping each way, now have the option of next leap being one of
        each 1 step, 2 steps, or 3 steps again.
         */
    }


    public static int countWays(int steps){
        return countWaysHelper(steps, new int[steps + 1]);
        // creates an array of zeros
    }


    private static int countWaysHelper(int steps, int[] visitedStairs){
        if (steps < 0){
            return 0;
        } else if (steps == 0){
            // subtracted perfectly to reach end of stairs
            // returns this the solution amount of times
            return 1;
        }
        if (visitedStairs[steps] == 0){
            visitedStairs[steps] = countWaysHelper(steps - 1, visitedStairs) +
                    countWaysHelper(steps - 2, visitedStairs) +
                    countWaysHelper(steps - 3, visitedStairs);
            // adds each time subtracted perfectly to reach end of stairs
            // ... spends a lot of time in this IF statement
        }
        return visitedStairs[steps];
        // returns this ONCE
    }


    public static void main(String[] args) {
        StairCases sc = new StairCases();
        // ez pz
        System.out.print(StairCases.countWays(13));
    }
}
