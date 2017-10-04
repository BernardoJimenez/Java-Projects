package generalChallenges;
import java.util.*;

public class LonelyInt{

    public int naiveFindLoner(int[] array){
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int number : array){
            Integer i = numbers.get(number);

            if (i == null){
                numbers.put(number, 1);
                // if not in Map, put in
            } else {
                numbers.remove(number);
                // if already in map, take out
                // only Key left will be the lonely int
            }
        }
        return (int) numbers.keySet().toArray()[0];
        // changes numbers map to set, then to array and
        // returns first element from array
    }


    public int findLoner(int[] array){
        int value = 0;

        for (int number : array){
            value ^= number;
            // XOR with each bit
            // returns 0(false) if there are pairs
            // returns 1(true) if not
            // resulting binary number = value
        }
        return value;
    }


    // MAIN
    public static void main(String[] args) {
        int[] a = {1,1,2,2,3,3,4,5,5,6,6,7,7,8,8,9,9};
        System.out.println(new LonelyInt().findLoner(a));
    }
}
