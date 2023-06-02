package test1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Interval {
    int start;
    int end;
    public  Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class MergeOverlappingIntervals {


    public static List<Interval> merge(List<Interval> inputList) {
        inputList.sort((a,b) -> Integer.compare(a.start, b.start));
        Iterator<Interval> iterator = inputList.iterator();
        List<Interval> resultList = new ArrayList<>();
        int start=0;int end=0;
        if(iterator.hasNext()) {
            Interval first = iterator.next();
            start=first.start;
            end = first.end;
        }
        while(iterator.hasNext()) {
            Interval itrvl = iterator.next();
            if(itrvl.start<end) {
                end = Math.max(end, itrvl.end);
            } else {
                resultList.add(new Interval(start, end));
                start = itrvl.start;
                end = itrvl.end;
            }
        }
        resultList.add(new Interval(start, end));
        return resultList;
    }
    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(7, 9));
        System.out.println("Merged intervals: ");
        List<Interval> resultList = merge(intervals);
        resultList.forEach((a) -> System.out.println("interval: "+a.start+","+a.end));
    }
}
