import java.util.Arrays;

public class NumbersSortArrangement {

    public static int[] fix(int[] arr) {
        for(int i=0;i<arr.length;) {
            if(arr[i]!=-1 && arr[i]!=i) {
                int temp = arr[i];
                int valTemp = arr[temp];
                arr[temp] = temp;
                arr[i] = valTemp;
            } else {
                i++;
            }
        }
        return arr;
    }
    public static void main(String args[]) {
        int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        System.out.println(Arrays.toString(fix(A)));
    }
}
