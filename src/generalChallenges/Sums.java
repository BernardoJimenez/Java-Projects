package generalChallenges;
import java.util.*;

public class Sums {

    /*
    Given an array and a target, find the first two numbers' indices that
    add to the target.
     */
    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // stores what the compliment would need to be for each index
        // value in order to add to target
        int[] result = {-1, -1};

        if (numbers.length < 2){
            return result;
        }

        for (int i = 0; i < numbers.length; i++){
            // i is index in numbers[]
            if (map.containsKey(numbers[i])){
                // if our HashMap has the next number in the numbers[]
                int index = map.get(numbers[i]);
                // get value for that key. Value is the index
                // in the numbers[]
                result[0] = index;
                result[1] = i;
                break;
                // break out of for loop
            } else {
                map.put((target - numbers[i]), i);
                // Key: compliment for value at current index
                // to add to target
                // Value: the index
            }
        }
        // returns {-1, -1} if no solution
        return result;
    }


    public int[] twoSumOnSorted(int[] numbers, int target){
        // same as twoSum but to use on a sorted Array
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        int[] result = {-1, -1};

        if (numbers.length < 2){
            return result;
        }

        while (i < j){
            sum = numbers[i] + numbers[j];
            if (sum < target){
                i++;
            } else if(sum > target){
                j--;
            } else if (sum == target){
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
        // returns {-1, -1} if no solution
        return result;
    }


    /*
    return the minimum size of subarray necessary to equal or pass target
    return 0 if not found
     */
    public int solSize(int[] numbers, int target){
        Arrays.sort(numbers);
        int windowSum = numbers[numbers.length/2];
        int start = numbers.length/2;
        int end = numbers.length/2;
        List<Integer> sum = new ArrayList<>();
        sum.add(numbers[start]);
        int sumSize = 1;

        while (true) {
            if (windowSum >= target) {
                if (windowSum - sum.get(0) >= target){
                    sum.remove(0);
                    sumSize -= 1;
                }
                break;
            } else if (end + 1 < numbers.length) {
                sumSize++;
                end++;
                sum.add(numbers[end]);
                windowSum += numbers[end];
            } else {
                return 0;
            }
        }
    return sumSize;
    }





    // MAIN
    public static void main(String[] args){
        Sums summy = new Sums();

        // solSize tests
        int[] example = {1, 4, 7, 2, 8, 8, 5, 2, 4, 0};

        for (int num : summy.twoSum(example, 16)){
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println(summy.solSize(example, 28));
        System.out.println(summy.solSize(example, 20));
        System.out.println(summy.solSize(example, 12));
        System.out.println(summy.solSize(example, 3));
        System.out.println(summy.solSize(example, 280));
    }
}
