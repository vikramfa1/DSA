public class CircularArrayCycle {

    public static boolean loopExists(int[] arr) {
        int slowPtr = 0; int fastPtr =0;

        for(int i=0;i<arr.length;i++) {

            slowPtr  = i;
            fastPtr = i;
            boolean direction = arr[i]>=0;

            do {
                slowPtr = getNextIndex(arr, slowPtr, direction);
                fastPtr = getNextIndex(arr, fastPtr, direction);
                if (fastPtr != -1) {
                    fastPtr = getNextIndex(arr, fastPtr, direction);
                }
            } while(slowPtr!=-1 && fastPtr!=-1 && slowPtr!=fastPtr);

            if(slowPtr!=-1 && slowPtr == fastPtr) {
                return true;
            }

        }
        return false;
    }

    private static int getNextIndex(int[] arr, int index, boolean direction) {
        boolean tempDirection = arr[index]>=0;
        if(tempDirection!=direction) {
            return -1;
        }

        int nextIndex = (index+arr[index])%arr.length;
        if(nextIndex<0) {
            nextIndex = nextIndex+ arr.length;
        }

        if(index == nextIndex) {
            return -1;
        }
        return nextIndex;
    }

    public static void main(String args[]) {

        System.out.println(CircularArrayCycle.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayCycle.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayCycle.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}
