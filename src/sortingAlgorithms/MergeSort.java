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



    // Let's start with an easier but related question I've seen out in the wild:
    // Given two sorted arrays, combine them into one sorted array...
    public static void main(String args[]){
        int[] arr1 = {1, 2, 2, 3, 12, 30, 88, 99, 11351};
        int[] arr2 = {-100, 0, 2, 4, 29, 31, 45, 67, 100, 538764};
        int[] answer = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;
        int newIndex = 0;

        while (index1 < arr1.length | index2 < arr2.length){
            if (index2 >= arr2.length ||
                    (index1 < arr1.length && (arr1[index1] <= arr2[index2]))){
                // boi that is a wild logic statement
                answer[newIndex] = arr1[index1];
                newIndex++;
                index1++;
            } else {
                answer[newIndex] = arr2[index2];
                newIndex++;
                index2++;
            }
        }

        for (int i : answer){
            System.out.print(i + " ");
        }
     //
    }

}
