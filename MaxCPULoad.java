import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int cpuLoad;
    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
}
public class MaxCPULoad {


    public static int findMaxCPULoad(List<Job> jobList) {
        Collections.sort(jobList, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(jobList.size(), (a, b) -> Integer.compare(a.end, b.end));
        int maxLoad=0;
        int currentCPULoad=0;
        for(Job job: jobList) {
            while(!priorityQueue.isEmpty() && job.start>=priorityQueue.peek().end) {
                currentCPULoad = currentCPULoad - priorityQueue.poll().cpuLoad;
            }
            priorityQueue.offer(job);
            currentCPULoad+=job.cpuLoad;

            maxLoad = Math.max(maxLoad, currentCPULoad);

        }
        return maxLoad;
    }
    public static void main(String args[]) {

        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3),
                new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " +
                MaxCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11),
                new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " +
                MaxCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1),
                new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " +
                MaxCPULoad.findMaxCPULoad(input));
    }
}
