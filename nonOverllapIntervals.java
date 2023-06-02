package test1;


import java.util.Arrays;

public class nonOverllapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        for(int[] ints: intervals) {
         System.out.println("s: "+ints[0]+","+ints[1]);
        }
        int n = intervals.length;
        int count = 1;

        if (n == 0){
            return 0;
        }

        int[] current = intervals[0];

        for (int i = 0; i < n; i++) {
            System.out.println("curr: "+current[0]+","+current[1]+", inter: "+intervals[i][0]);
            if (current[1] <= intervals[i][0]) {
                count += 1;
                current = intervals[i];
            }
        }

        return n - count;
    }

    public static void main(String args[]) {
        int[][] val = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(val));

    }
}
