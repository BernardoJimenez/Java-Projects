package sortingAlgorithms;

public class BubbleSort {

    public static void sort(int[] userArray) {
        // Bubble BubbleSort
        int userLength = userArray.length;
        int tempy = 0;

        for (int i=0; i < userLength; i++) {
            // for each element of user array
            for (int j=1; j < (userLength-i); j++) {
                // (userLength-i represents how many more positions to check
                if (userArray[j-1] > userArray[j]) {
                    // if current element is greater than next element
                    // swap the elements
                    tempy = userArray[j-1];
                    // store current val
                    userArray[j-1] = userArray[j];
                    // make current next
                    userArray[j] = tempy;
                    // make next current
                }
            }
        }
    }
    
}
