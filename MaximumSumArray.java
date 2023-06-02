package test2;

public class MaximumSumArray {
    public int findMaxSumSubArray(int k, int[] arr) {

        int lPtr= 0;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int rPtr =0; rPtr<arr.length;rPtr++) {

            if(rPtr-lPtr<=k-1) {
                currSum += arr[rPtr];
            } else {
                currSum = currSum+arr[rPtr]-arr[lPtr];
                lPtr++;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSumArray sol = new MaximumSumArray();
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}

