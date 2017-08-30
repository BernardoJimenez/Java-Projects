package mathBased;

public class FibonacciSequence {

    private static int[] lastTwo = {0, 1};
    private static int latestNumber = 0;
    private static int cycles = 0;

    public static void printFibonacci(int sequenceLength) {
        // Print Fibonacci sequence N number of positions
        while (sequenceLength != 0){
            if (cycles < 2) {
                System.out.println(lastTwo[cycles]);
                cycles++;
                sequenceLength--;
            } else {
                latestNumber = lastTwo[0] + lastTwo[1];
                System.out.println(latestNumber);
                lastTwo[0] = lastTwo[1];
                lastTwo[1] = latestNumber;
                sequenceLength--;
            }
        }
    }


}