package test1;

import java.util.Arrays;

public class MoveZeros {
    private static void sortNumberWithZeros(int[] arr) {
        int leftPtr = 0;
        int rightPtr = 0;
        while(rightPtr<arr.length) {
            if(arr[rightPtr]==0) {
                rightPtr++;
            } else {
                arr[leftPtr] = arr[rightPtr];
                leftPtr++;
                rightPtr++;
            }
        }
        while(leftPtr<arr.length) {
            arr[leftPtr]=0;
            leftPtr++;
        }
    }
    public static void main(String args[]) {
        int[] val = {0,1,0,3,12,0,0,15,0,17};
        sortNumberWithZeros(val);
        Arrays.stream(val).forEach(a -> System.out.println("val: "+a));
    }
}
