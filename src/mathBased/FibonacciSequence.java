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

    public static int recursiveFib(int size){
        return recursiveFibHelper(size, new int[size + 1]);
    }

    public static int recursiveFibHelper(int n, int[] memo){
        if (n == 1 || n == 2){
            return 1;
        } else if (n == 0){
            return 0;
        } else if (memo[n] == 0){
            memo[n] = recursiveFibHelper(n-1, memo) + recursiveFibHelper(n-2, memo);
        }
        return memo[n];
    }

    public static void main(String[] args){
        System.out.println(FibonacciSequence.recursiveFib(3));
    }


}