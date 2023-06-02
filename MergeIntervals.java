import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}*/
public class MergeIntervals {

    /*public static List<Interval> merge(List<Interval> list) {

        if(list.size()<2) {
            return list;
        }
        List<Interval> resultList = new ArrayList<>();
        Collections.sort(list, (a,b) -> Integer.compare(a.start,b.start));
        Iterator<Interval> intervalIterator = list.iterator();

        Interval startShift = intervalIterator.next();
        int start = startShift.start;
        int end = startShift.end;
        while(intervalIterator.hasNext()) {
            startShift = intervalIterator.next();
            if(startShift.start<=end) {
                end = Math.max(end, startShift.end);
            } else {
                resultList.add(new Interval(start, end));
                start = startShift.start;
                end = startShift.end;
            }
        }

        resultList.add(new Interval(start, end));
        return resultList;
    }

    public static void main(String args[]) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
*/
}
