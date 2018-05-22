package mathBased;

public class MaxSubArraySum {

    // Find the maximum possible sum in arr[]
    // such that arr[midpoint] is included
    public static int maxCrossingSum(int[] arr, int l, int m, int r){
        // l would be typically 0
        // r would be typically (arr.length - 1)
        // m would be typically r/2

        // include elements on left <- of the array's midpoint
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = m; i >= l; i--){ // l, not 1
            sum = sum + arr[i];

            if (sum > leftSum){
                leftSum = sum;
            }
        }
        // include elements on right -> of midpoint
        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = m + 1; i <= r; i++){
            sum = sum + arr[i];

            if (sum > rightSum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    // Returns max sum of a continuous subarray
    // contained within the input array
    private static int maxSubArraySumHelper(int[] arr, int l, int r){
        // Base case: only 1 element
        if (l == r){
            return arr[l];
        }
        // Find middle point
        int m = (l + r)/2;
        /* Return the maximum of the following three:
        a) Max subarray sum in left half
        b) Max subarray sum in right half
        c) Max subarray sum crossing over the midpoint
         */
        return Math.max(Math.max(maxSubArraySumHelper(arr, l, m),
                maxSubArraySumHelper(arr, m+1, r)),
                maxCrossingSum(arr, l, m, r));
    }

    public static int maxSubArraySum(int[] arr){
        return maxSubArraySumHelper(arr, 0, arr.length-1);
    }


    public static void main(String[] args){
        int[] arr = {2, 3, 4, -500, 11, -12, 5, -1, 0, 7};
        int maxSum = MaxSubArraySum.maxSubArraySum(arr);

        System.out.print("Max sum of " + arr + " is " + maxSum);
    }
}