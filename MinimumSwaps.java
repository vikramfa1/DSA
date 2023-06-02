import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps {

    private static int minimumSwaps(int[] arr) {
        int[] temp = Arrays.copyOfRange(arr,0, arr.length);
        int ans=0;
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=temp[i]) {
                ans++;
                int init = arr[i];

                swap(arr, i, map.get(temp[i]));
                int j= map.get(temp[i]);
                map.put(temp[i], i);
                map.put(init, j);

            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
    public static void main(String args[]) {
        int[] a
                = { 101, 758, 315, 730, 472, 619, 460, 479 };
        int n = a.length;
        System.out.println(MinimumSwaps.minimumSwaps(a));
    }
}
