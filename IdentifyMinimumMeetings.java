package test1;

import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class IdentifyMinimumMeetings {

    public static int findMinimumMeetingRooms(List<Meeting> arrList) {
        arrList.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Meeting> priorityQueue = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        int maxLength=Integer.MIN_VALUE;
        for(Meeting meeting: arrList) {
            while(!priorityQueue.isEmpty() && meeting.start>=priorityQueue.peek().end) {
                priorityQueue.poll();
            }

            priorityQueue.offer(meeting);

            maxLength = Math.max(maxLength, priorityQueue.size());

        }
            return maxLength;
    }
    public static void main(String args[]) {
        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        int result = IdentifyMinimumMeetings.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        result = IdentifyMinimumMeetings.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        result = IdentifyMinimumMeetings.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        result = IdentifyMinimumMeetings.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }

}
