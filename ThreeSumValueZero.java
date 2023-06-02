package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumValueZero {

    public static List<List<Integer>>  threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> intSum = new ArrayList<>();
        for(int i=0;i<num.length;i++){

            if(i==0 || (i>0 && num[i]!=num[i-1])) {
                searchPair(num, num[i], i  ,intSum);
            }
        }
        return intSum;
    }

    public static void searchPair(int[] num, int sum, int prevStart, List<List<Integer>> resultList) {
        int start = prevStart+1;
        int end = num.length-1;
        while(start<end) {
            if(num[start]+num[end]+sum>0) {
                end--;
            } else if(num[start]+num[end]+sum<0) {
                start++;
            } else {
                resultList.add(List.of(num[prevStart], num[start], num[end]));
                start++;
                end--;

                while(start<end && num[start]==num[start-1]) {
                    start++;
                }

                while(start<end && num[end]==num[end+1]) {
                    end--;
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> resultList = threeSum(nums);
        resultList.forEach(a -> {
            System.out.println();
            a.forEach(b -> System.out.print(b+","));
        });
    }
}
