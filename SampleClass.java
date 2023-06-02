import java.util.List;
import java.util.ArrayList;

public class SampleClass {
    private static List<List<Integer>> findSubarrayProduct(int[] arr, int target) {
        if(arr==null)
            return null;
        int leftPtr = 0;
        int rightPtr = leftPtr+1;
        int prdoct = arr[0];
        List<List<Integer>> resultList = new ArrayList<>();
        for(;rightPtr<arr.length; rightPtr++) {
            prdoct = arr[rightPtr]*prdoct;
            while(prdoct>=target && leftPtr<arr.length) {
                prdoct = prdoct/arr[leftPtr];
                leftPtr++;
            }

            List<Integer> interResult = new ArrayList<>();
            for(int i=rightPtr;i>=leftPtr;i--) {
                interResult.add(0, arr[i]);
                resultList.add(new ArrayList<>(interResult));
            }



        }
        System.out.println("resultList:"+resultList);
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(
                SampleClass.findSubarrayProduct(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(
                SampleClass.findSubarrayProduct(new int[] { 8, 2, 6, 5 }, 50));
    }
}
