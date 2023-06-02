package test1;

public class HappyNumber {

    private static boolean isHappyNumber(int val) {
        int slowPtr = val;
        int fastPtr = val;
        while(true) {
            slowPtr = returnSquareNumber(slowPtr);
            fastPtr = returnSquareNumber(returnSquareNumber(fastPtr));
            if(slowPtr==fastPtr) {
                break;
            }
        }
        return slowPtr == 1;
    }

    private static int returnSquareNumber(int val) {
        int result=0;
        while(val>0) {
            int n = val%10;
            int digit = n*n;
            result +=digit;
            val = val/10;
        }
        return result;
    }
    public static void main(String args[]) {
        System.out.println(isHappyNumber(23));
    }
}
