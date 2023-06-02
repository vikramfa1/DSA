import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctElementsWindow {

    private static List<Integer> findDistinctElementsInWindowK(int[] arr, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int leftPtr=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<K;i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        list.add(map.size());
        for(int rightPtr=K;rightPtr<arr.length;rightPtr++) {

            if(map.get(arr[rightPtr-K])>1) {
                map.put(arr[rightPtr-K], map.getOrDefault(arr[rightPtr-K],0)-1);
            } else {
                map.remove(arr[rightPtr-K]);
            }
            map.put(arr[rightPtr], map.getOrDefault(arr[rightPtr],0)+1);
            System.out.println("map:"+map);
            list.add(map.size());
        }
        return list;
    }
    public static void main(String args[]) {
        String val= Stream.iterate(new int[]{0,1}, n->new int[]{n[1],n[0]+n[1]})
                .limit(10)
                .map(n->String.valueOf(n[0]))
                .collect(Collectors.joining(","));
        System.out.println("fibonacci:"+val);
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int K = 4;
        System.out.println(DistinctElementsWindow.findDistinctElementsInWindowK(arr,K));
    }
}
