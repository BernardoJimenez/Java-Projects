package sortingAlgorithms;

public class InsertionSort {

    public static void sort(int userArr[]) {
        for (int i = 1; i < userArr.length; ++i){
            // key works to temporarily save item at current index
            int key = userArr[i];
            int j = i-1;

            // BOTH j less than 0 AND there is a number encountered greater than key
            while (j >= 0 && userArr[j] > key){
                // swap with every single number to left of current
                // only if it is a greater number
                // otherwise keep walking down array
                userArr[j+1] = userArr[j];
                j--;
            }
            userArr[j+1] = key;
        }
    }


    public static void main(String[] args){
        int[] testy = {3, 4, 2, 7, 4, 8, 1, 0, 10, 3};
        InsertionSort.sort(testy);

        for (int i : testy){
            System.out.print(i + " ");
        }
    }
}
