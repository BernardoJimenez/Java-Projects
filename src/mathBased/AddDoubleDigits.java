package mathBased;

public class AddDoubleDigits {
    /*
    Input: an array of ints
    Output: an int
    Description: adds together all double digit numbers in an array
     */
    public int addDigits(int[] numbers){
        int answer = 0;

        for (int number : numbers){
            if ((Math.abs(number) > 9 && Math.abs(number) < 100)){
                answer += number;
            }
        }
        return answer;
    }
}
