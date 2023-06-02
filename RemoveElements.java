package test1;

import java.util.Arrays;

public class RemoveElements {

    private static void removeElements(int[] arr, int val) {
        int left=0, right =0;
        while(right<arr.length) {
            if(arr[right]!=val) {
                arr[left] = arr[right];
                left++;
                right++;
            } else {
                right++;
            }
        }
        while(left<arr.length) {
            arr[left] = -2;
            left++;
        }
    }
    public static void main(String args[]) {
        int[] nums = {0,1,2,2,3,0,4,2}; int val = 2;
        removeElements(nums, val);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}
