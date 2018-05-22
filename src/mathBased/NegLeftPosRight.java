package mathBased;
import java.util.ArrayList;
import java.util.List;

public class NegLeftPosRight {

    public Integer[] orderDual(int[] numbers){
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (Integer number : numbers){
            if (number < 0){
                leftList.add(number);
            } else {
                rightList.add(number);
            }
        }

        leftList.addAll(rightList);

        Integer[] answer = leftList.toArray(new Integer[leftList.size()]);

    return answer;
    }


    public int[] orderNoLists(int[] numbers){
        int[] answer = new int[numbers.length];
        int index = 0;

        for (int number : numbers){
            if (number < 0){
                answer[index] = number;
                index++;
            }
        }
        for (int number : numbers){
            if (number >= 0){
                answer[index] = number;
                index++;
            }
        }
        return answer;
    }


    public void orderCS(int[] numbers){
        // constant space
        // No Recursion allowed
        int key, j;

        for (int i = 1; i < numbers.length; i++){
            key = numbers[i];
            // if current element is positive
            if (key >= 0){
                // do nothing
                continue;
            }
            /* if current element is negative,
            shift positive elements of numbers[0... i-1]
            to one position to their right.
             */
            j = i-1;

            while (j >= 0 && numbers[j] >= 0){
                // two conditions to satisfy
                // make sure j in range of array
                // make sure number at that index j is positive
                numbers[j+1] = numbers[j];
                // the number at index j is copied to j+1
                j--;
                // move j index to left one
            }
            // Put negative element at its position
            numbers[j + 1] = key;
            // j ends where first original positive number was
            // that and all other pos numbers were moved left
            // so now can take place of first pos number,
            // since last pos number took its(negative number encountered) place
        }
    }// n squared ... others O(n)


    public static void main(String[] args){
        NegLeftPosRight nlpr = new NegLeftPosRight();
        int[] numbers = {1, -1, -3, 0, 5, -8};
        int[] moreNumbers = {0, 1, 2, 3, 4, -1, 0, 11, -11, -2, -3, -4, -5};
        int[] answer = nlpr.orderNoLists(numbers);
        nlpr.orderCS(moreNumbers);

        for (Integer number : moreNumbers){
            System.out.print(number + " ");
        }

        System.out.println();

        for (Integer number : answer){
            System.out.print(number + " ");
        }
    }
}
