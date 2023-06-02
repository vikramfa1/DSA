
class HappyNumberUsingCycle {

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            System.out.println("digit:"+digit);
            sum += digit * digit;
            num /= 10;
            System.out.println("num:"+num);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumberUsingCycle.find(23));
        System.out.println(HappyNumberUsingCycle.find(12));
    }
}
