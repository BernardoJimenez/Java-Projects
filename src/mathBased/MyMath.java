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
    public void powerOfChecker(int n, int number){
        double dNum = number;
        // have number as a double to represent decimal values
        boolean answer = true;

        while(dNum != n){
            dNum = dNum / n;
            // continuously divide dNum by power: n
            if (dNum != ((int) dNum)){
                // if dNum is now not a whole number
                answer = false;
                break;
            }
        }

        if (answer){
            System.out.println(number + " is a power of " + n);
        } else {
            System.out.println(number + " is NOT a power of " + n);
        }
    }


    // MAIN
    public static void main(String[] args){
        MyMath math = new MyMath();

        math.powerOfChecker(2, 17);
        math.powerOfChecker(2, 64);
    }
}
