package sortingAlgorithms;

public class InsertionSort {

    public static void sort(int userArr[]) {
        for (int i=1; i < userArr.length; ++i)
        {
            int key = userArr[i];
            int j = i-1;

            while (j >= 0 && userArr[j] > key)
            {
                userArr[j+1] = userArr[j];
                j = j-1;
            }
            userArr[j+1] = key;
        }
    }
}
