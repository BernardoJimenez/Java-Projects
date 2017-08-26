package sortingAlgorithms;

public class SelectionSort {

    public static void sort(int[] userArr){
        for (int i = 0; i < userArr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < userArr.length; j++)
                if (userArr[j] < userArr[index])
                    index = j;

            int newMin = userArr[index];
            userArr[index] = userArr[i];
            userArr[i] = newMin;
        }
    }

}
