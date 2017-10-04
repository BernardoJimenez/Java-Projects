package mathBased;
import java.util.Random;

public class MyMath {

    public static double mySqrt(int number) {
        /*
        * Implement square root
        * Input: int
        * Output: a Double representing the square of user's int
         */
        double tempy = number;
        double answer = tempy;

        while ((answer - (tempy/answer)) != 0) {
            answer = ((tempy/answer) + answer) / 2.0;
        }
        return answer;
    }


    public static int myMultiply(int number, int times) {
        /*
        * Implement multiply
        * Input: user int of numbers to multiply
        * Output: their product as an int
         */
        int i = 0;
        int answer = 0;

        if (times == 0 || number == 0) {
            answer = 0;
        } else {
            // iterate adding number to answer "times"
            // number of times
            while (i != times) {
                answer = answer + number;
                i++;
            }
        }
        return answer;
    }


    // Given a function rand5() that returns a
    // random int between 0 and 5, implement rand7()
    public static int rand5(){
        Random rand5 = new Random();
        return rand5.nextInt(6);
    }

    public static int rand7(){
        return rand5() + (rand5() / 2);
        // is it that easy?
    }


    /*
    return whether number is a power of n
     */
    public void powerOfChecker(int n, int number) {
        double dNum = number;
        // have number as a double to represent decimal values
        boolean isAPower = true;

        if (number == 1){
            // n^0 = 1 always
            isAPower = true;
        } else if (number == 0) {
            isAPower = false;
        } else {
            while (dNum != n) {
                dNum /= n;
                // continuously divide dNum by power: n
                if (dNum != ((int) dNum)) {
                    // if dNum is now not a whole number
                    isAPower = false;
                    break;
                }
            }
        }

        if (isAPower){
            System.out.println(number + " is a power of " + n);
        } else {
            System.out.println(number + " is NOT a power of " + n);
        }
    }


    /*
    return whether if decimal value is a power of n
     */
    public void powerOfChecker(int n, double number){
        // yay polymorphism
        double dNum = number;
        boolean isAPower = false;

        if (number == 0){
            isAPower = false;
        } else if (number == 1.0){
            isAPower = true;
        } else {
            while (dNum < n) {
                dNum *= n;
                // continuously divide dNum by power: n
                if (dNum == n) {
                    isAPower = true;
                    break;
                }
            }
        }

        if (isAPower){
            System.out.println(number + " is a power of " + n);
        } else {
            System.out.println(number + " is NOT a power of " + n);
        }
    }


    public void checkIfPrime(int number) {
        int num = number;
        boolean isPrime = true;

        // check if 2 divides number cleanly
        // 2 is the only even Prime
        if (num < 2 ||
                (num % 2 == 0 && num != 2)) {
            // if no remainder
            // and not even, except for 2
            isPrime = false;
        } else {
            // otherwise, divide by odd numbers
            for (int i = 3; i <= num / 2; i += 2) {
                // any i higher than half of number for sure will not
                // divide number cleanly
                if (num % i < 1) {
                    isPrime = false;
                }
            }
        }
        if (isPrime) {
            System.out.println(number + " is Prime.");
        } else {
            System.out.println(number + " is NOT prime.");
        }
    }


    // MAIN
    public static void main(String[] args){
        MyMath math = new MyMath();

        math.powerOfChecker(2, 17);
        math.powerOfChecker(2, 64);
        math.powerOfChecker(3, 0);
        math.powerOfChecker(2, 0.125);
        math.powerOfChecker(7, 0.5425);
        math.powerOfChecker(100, 1.0);

        System.out.println();
        math.checkIfPrime(0);
        math.checkIfPrime(1);
        math.checkIfPrime(5);
        math.checkIfPrime(2);
        math.checkIfPrime(11);
        math.checkIfPrime(129);
    }
}
