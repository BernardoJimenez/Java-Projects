package textBased;

public class FizzBuzz {
    // Fizz Buzz - Write a program that prints the fbNumbers from 1 to 100. But for multiples of three print “Fizz”
    // instead of the number and for the multiples of five print “Buzz”. For fbNumbers which are multiples of
    // both three and five print “FizzBuzz”

    private static int[] fbNumbers = new int[100];
    private static int realNum = 1;

    public static void printFizzBuzz() {
        while (realNum < 101) {
            // fill the array with fbNumbers 1 to 100
            if (((realNum % 3) == 0) || ((realNum % 5) == 0)) {
                // if number is a multiple of 3 OR 5
                if (((realNum % 3) == 0) && ((realNum % 5 == 0))) {
                    // if a multiple of both, replace with 1000
                    fbNumbers[realNum - 1] = 1000;
                    realNum++;
                } else if ((realNum % 5) == 0) {
                    // if multiple of just 5, replace with 750
                    fbNumbers[realNum - 1] = 750;
                    realNum++;
                } else {
                    // if multiple of just 3, replace with 500
                    fbNumbers[realNum - 1] = 500;
                    realNum++;
                }
            } else {
                // if not a multiple, just return next number
                fbNumbers[realNum - 1] = realNum;
                realNum++;
            }
        }

        for (int fbNumber : fbNumbers) {
            // print fbNumbers
            if (fbNumber < 500) {
                // if less than 500, return number at current index
                System.out.println(fbNumbers[fbNumber - 1]);
            } else if (fbNumber < 750) {
                // if multiple of 3, return Fizz
                System.out.println("Fizz");
            } else if (fbNumber < 1000) {
                // if multiple of 5, return Buzz
                System.out.println("Buzz");
            } else {
                // if multiple of both, return FizzBuzz
                System.out.println("FizzBuzz");
            }
        }
    }
}