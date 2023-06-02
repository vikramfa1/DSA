package test1;

public class HeapCheck {

    public static boolean checkBinaryHeap(int[] arr) {
        return isHeap(arr, 0, arr.length-1);
    }

    private static boolean isHeap(int[] arr, int i, int n) {

        if(i>= (n-1)/2) {
            return true;
        }

        return arr[i] >= arr[(2 * i + 1)] && arr[i] >= arr[(2 * i + 2)]
                && isHeap(arr, 2 * i + 1, n) && isHeap(arr, 2 * i + 2, n);


    }
    public static void main(String args []) {
        int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        boolean val = checkBinaryHeap(arr);
        System.out.println("required: "+val);
    }
}
