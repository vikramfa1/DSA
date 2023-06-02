package test2;

public class MinimumLengthSubArray {
    public static int findMinSubArray(int S, int[] arr) {
        int minLength = Integer.MAX_VALUE;
        int lPtr = 0;
        int currSum=0;
        for(int rPtr=0;rPtr<arr.length;rPtr++) {

            currSum+=arr[rPtr];
            while(currSum>=S) {
                minLength = Math.min(minLength, rPtr-lPtr+1);
                currSum = currSum- arr[lPtr];
                lPtr++;
            }

        }
        return minLength;
    }

    public static void main(String[] args) {
        int result = MinimumLengthSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinimumLengthSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinimumLengthSubArray.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}