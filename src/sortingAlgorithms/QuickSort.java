package sortingAlgorithms;
import java.util.*;

public class QuickSort {

    public static List<Integer> sort(List<Integer> userValues) {
        if (userValues.size() < 2) {
            return userValues;
        }

        double pivot = userValues.get(new Random().nextInt(userValues.size()));
        // if using last element as Pivot, could have O(N) in worst case
        List<Integer> Lower = new ArrayList<>();
        List<Integer> Pivots = new ArrayList<>();
        List<Integer> Higher = new ArrayList<>();

        for (int i : userValues) {
            if (i < pivot) {
                Lower.add(i);
            } else if (i == pivot) {
                Pivots.add(i);
            } else {
                Higher.add(i);
            }
        }

        userValues.clear();

        // if all the same elements, return
        if (Lower.isEmpty() && Higher.isEmpty()) {
            return Pivots;
        }

        Lower = sort(Lower);
        Higher = sort(Higher);

        userValues.addAll(Lower);
        userValues.addAll(Pivots);
        userValues.addAll(Higher);

        return userValues;
    }



    public static int[] intListToArray(List<Integer> intList) {
        int[] answer = new int[intList.size()];
        int index = 0;

        for (int i : intList) {
            answer[index] = i;
            index++;
        }

        return answer;
        // ADDS O(N) RUNTIME TO RETURN-ARRAY VERSION OF QUICKSORT
    }


    public static int[] sort(int[] userValues) {
        if (userValues.length < 2) {
            return userValues;
        }

        int pivot = new Random().nextInt(userValues.length);
        List<Integer> Lower = new ArrayList<>();
        List<Integer> Pivots = new ArrayList<>();
        List<Integer> Higher = new ArrayList<>();

        for (int i : userValues) {
            if (i < pivot) {
                Lower.add(i);
            } else if (i == pivot) {
                Pivots.add(i);
            } else {
                Higher.add(i);
            }
        }

        // check if all elements the same
        if (Higher.isEmpty() && Lower.isEmpty()) {
            return intListToArray(Pivots);
        }

        Lower = sort(Lower);
        Higher = sort(Higher);

        List<Integer> returnedValues = new ArrayList<>();
        returnedValues.addAll(Lower);
        returnedValues.addAll(Pivots);
        returnedValues.addAll(Higher);

        return intListToArray(returnedValues);
    }
}
