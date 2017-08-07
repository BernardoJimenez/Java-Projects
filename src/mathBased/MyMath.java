package mathBased;


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



}
