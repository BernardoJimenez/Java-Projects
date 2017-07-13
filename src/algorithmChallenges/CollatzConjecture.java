package algorithmChallenges;

public class CollatzConjecture {
    // Start with a number randNumCC > 1. Find the number of steps it takes to reach one using the following process:
    // If randNumCC is even, divide it by 2. If randNumCC is odd, multiply it by 3 and add 1.

    private int randNumCC = (int) ((Math.random() * 999) + 2);
    // pick a random integer between 2 and 1000
    private int orginalCCNum = randNumCC;

    public final void solveCollatz() {
        System.out.println("N is equal to " + orginalCCNum);

        int steps = 0;
        // counter to see how many steps it takes to get to the number one from "randNumCC"

        while (randNumCC != 1) {
            if (randNumCC % 2 == 0) { // randNumCC is even
                System.out.print(randNumCC + " divided by 2 is ");
                randNumCC = randNumCC / 2;
                System.out.println(randNumCC);
                steps++;
            } else { // randNumCC is odd
                System.out.print(randNumCC + " times 3 plus 1 is ");
                randNumCC = ((randNumCC * 3) + 1);
                System.out.println(randNumCC);
                steps++;
            }
        }
        System.out.println("It took " + steps + " steps to get from " + orginalCCNum + " to " + randNumCC);
    }
}