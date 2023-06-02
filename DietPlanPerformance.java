public class DietPlanPerformance {

    private static int dietPlanPerformance(int[] cal, int k, int lower, int upper) {
        int totalPoints=0;
        int windowStart = 0;
        int currTotal = 0;
        for(int windowEnd = 0;windowEnd<cal.length;windowEnd++) {
            if(windowEnd<k-1) {
                System.out.println("1st if "+windowEnd);
                currTotal +=cal[windowEnd];
            } else if(windowEnd==k-1){
                currTotal +=cal[windowEnd];
                System.out.println("2nd if "+windowEnd);
                totalPoints = getTotalPoints(lower, upper, totalPoints, currTotal);
            } else {
                System.out.println("else "+windowEnd);
                currTotal = currTotal+cal[windowEnd]-cal[windowStart];
                windowStart++;
                totalPoints = getTotalPoints(lower, upper, totalPoints, currTotal);
            }
        }
        return totalPoints;
    }

    private static int getTotalPoints(int lower, int upper, int totalPoints, int currTotal) {
        if(currTotal < lower) {
            totalPoints -=1;
        } else if(currTotal > upper) {
            totalPoints +=1;
        }
        return totalPoints;
    }

    public static void main(String args[]) {
        int[] cal = {6,5,0,0};
        int k = 2;
        int lower = 1;
        int upper = 5;
        System.out.println("diet points: "+dietPlanPerformance(cal, k, lower, upper));
    }
}
