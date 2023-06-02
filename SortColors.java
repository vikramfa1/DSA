package test1;

import java.util.Arrays;

public class SortColors {
    private static void sortColors(int[] nums) {
        int p1=0;
        int p0=0;
        int p2=nums.length-1;
        while(p1<=p2) {

            if(nums[p1]==0) {
                int temp = nums[p0];
                nums[p0] = nums[p1];
                nums[p1] = temp;
                p0++;
                p1++;
            }
            else if(nums[p1]==2) {
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p2--;
            } else {
                p1++;
            }
        }
    }
    public static void main(String args[]) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}
