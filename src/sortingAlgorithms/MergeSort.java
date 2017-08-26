package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < mergedArr.length; k++) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    mergedArr[k] = arr1[i];
                    i++;
                } else {
                    mergedArr[k] = arr2[j];
                    j++;
                }
            } else {
                // probably redundant in some respects
                if (i >= arr1.length) {
                    mergedArr[k] = arr2[j];
                    j++;
                } else {
                    mergedArr[k] = arr1[i];
                    i++;
                }
            }
        }
        return mergedArr;
    }


    public static int[] sort(int[] userArr) {

        int splitHere = 0;

        if (userArr.length % 2 == 0) {
            splitHere = (userArr.length / 2) - 1;
        } else {
            splitHere = userArr.length / 2;
        }

        int[] firstHalf = Arrays.copyOfRange(userArr, 0, splitHere);
        int[] secondHalf = Arrays.copyOfRange(userArr, (splitHere + 1), (userArr.length - 1));


        return userArr; // for now
        // TODO: Finish lol
    }

}
