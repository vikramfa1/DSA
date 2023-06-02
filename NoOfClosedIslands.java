public class NoOfClosedIslands {

    public static int findNoOfClosedIslands(int[][] arr) {
        int xMax = arr.length;
        int yMax = arr[0].length;
        boolean[][] visited = new boolean[xMax][yMax];
        int count=0;
        /*for (int i = 0; i < xMax; i++) {
            for (int y = 0; y < yMax; y++) {
                cancelBorderIslands(arr, i, y, visited);
            }
        }*/
        for (int i = 0; i < xMax; i++) {
            for (int y = 0; y < yMax; y++) {
                if(!visited[i][y] && arr[i][y]==1 && isClosedIslands(arr, i, y, visited)) {
                    count++;
                }
            }
        }
    return count;
    }

    /*private static boolean cancelBorderIslands(int[][] arr, int i, int j, boolean[][] visited) {
        if(i*j==0 || i>=arr.length || j>=arr[0].length) {
            visited[i][j] = true;
        }
    }*/

    private static boolean isClosedIslands(int[][] arr, int i, int j, boolean[][] visited) {
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length) {
            return false;
        }
        if(visited[i][j] || arr[i][j]==0) {
            return true;
        }
        boolean isTrue = true;
        visited[i][j] = true;
        isTrue = isClosedIslands(arr, i+1, j, visited);
        isTrue = isTrue && isClosedIslands(arr, i, j-1, visited);
        isTrue = isTrue && isClosedIslands(arr, i-1, j, visited);
        isTrue = isTrue && isClosedIslands(arr, i, j+1, visited);
        return isTrue;
    }
    public static void main(String args[]) {
        // Given Matrix
        int[][] matrix = { { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 } };
        System.out.println(NoOfClosedIslands.findNoOfClosedIslands(matrix));
    }
}
