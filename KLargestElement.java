import java.util.Random;

public class KLargestElement {

    public static int findKthSmallestNumber(int[] arr, int k) {
        return quickSort(arr, 0, arr.length-1, k);
    }

    private static int quickSort(int[] arr, int start, int end, int k) {
System.out.println(start+","+end);
            int part = partition(arr, start, end);

            if(part==k-1) {
                return arr[part];
            } else if(part>k-1) {
                return quickSort(arr, start, part-1, k);
            } else {
                return quickSort(arr, part+1, end, k);
            }
        }

    /*private static int partition(int[] nums, int low, int high) {
        if (low == high)
            return low;

        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place
        swap(nums, low, high);
        return low;
    }*/
    private static int partition(int[] arr, int start, int end) {
        if(start==end) return start;
        //Random random = new Random();
        //int part = start+random.nextInt(end-start);
        //swap(arr, part, end);
        int part = end;
        int i=start;
        for(int j=0;j<end;j++) {
            System.out.println("j: "+j+","+part);
            if(arr[j]<arr[part]) {
                swap(arr, i, j);
                ++i;
            }
        }

        swap(arr, i, part);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {
        int result =
                KLargestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // as there're two 5s in input array, our 3rd and 4th smallest numbers should be '5'
        result =KLargestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KLargestElement.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
