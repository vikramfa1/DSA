package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Intervall {
    int start;
    int end;
    public Intervall(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {

    private static List<Intervall> mergeInterval(int[][] intervals) {
        PriorityQueue<Intervall> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.start,b.start));
        List<Intervall> finalList = new ArrayList<>();
        for(int[] interval: intervals)
            priorityQueue.add(new Intervall(interval[0],interval[1]));
        Intervall prev = priorityQueue.poll();
        while(!priorityQueue.isEmpty()) {
            Intervall curr = priorityQueue.poll();
            if(prev.end>curr.start) {
                prev.end = Integer.max(prev.end, curr.end);
            } else {
                finalList.add(new Intervall(prev.start, prev.end));
                prev = curr;
            }
        }
        finalList.add(new Intervall(prev.start, prev.end));
        return finalList;
    }
    public static void main(String args[]) {
        int[][] intervals = {{1,4}, {2,6}, {3,5}};
        List<Intervall> resultList = mergeInterval(intervals);
        resultList.forEach(a -> System.out.println(a.start+","+a.end));
    }
}
