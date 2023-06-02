import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsFind {

    private static List<List<Integer>> findTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> resultList = new ArrayList<>();
        int leftPtr = 0; int rightPtr = arr.length-1;
        int intSum = 0;
        for(int i=0;i<arr.length;i++) {
            if(i>0 && arr[i]-arr[i-1]==0) continue;
            leftPtr = i+1;
            while(leftPtr<rightPtr) {
                if (arr[i] + arr[leftPtr] + arr[rightPtr] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[leftPtr]);
                    list.add(arr[rightPtr]);
                    resultList.add(new ArrayList<>(list));


                    while(leftPtr<rightPtr && arr[leftPtr]-arr[leftPtr+1]==0) leftPtr++;
                    while(leftPtr<rightPtr && arr[rightPtr]-arr[rightPtr-1]==0) rightPtr--;
                    leftPtr++;
                    rightPtr--;
                    continue;
                }

                if(arr[i] + arr[leftPtr] + arr[rightPtr]>0) {
                    rightPtr--;
                    continue;
                } else {
                    leftPtr++;
                    continue;
                }



            }
        }
        System.out.println("res: "+resultList);
        return resultList;
    }
    public static void main(String args[]) {
        int arr[]={-1,0,1,2,-1,-4};
        System.out.println(TripletsFind.findTriplets(arr));
    }
}
