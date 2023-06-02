public class IslandPrograms {

    public static int findIslandPerimeter(int[][] arr) {
        int perimeter=0;
        boolean[][] visited = new boolean[arr.length][arr.length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j]==1 && !visited[i][j]) {
                    perimeter+=findPerimeter(arr, visited, i, j);
                }
            }
        }
        return perimeter;
    }

    private static int findPerimeter(int[][] arr, boolean[][] visited, int i, int j) {
        if(i<0 || i>=arr.length || j<0 || j>=arr.length) {
            return 1;
        }
        if(arr[i][j]==0) {
            return 1;
        }
        if(visited[i][j]) {
            return 0;
        }
        int perimeter =0;
        visited[i][j] = true;
        System.out.println("i,j:"+i+","+j);
        perimeter +=findPerimeter(arr, visited, i+1,j);
        perimeter +=findPerimeter(arr, visited, i,j-1);
        perimeter +=findPerimeter(arr, visited, i-1,j);
        perimeter +=findPerimeter(arr, visited, i,j+1);
        return perimeter;
    }
    public static void main(String args[]) {

        System.out.println(IslandPrograms.findIslandPerimeter(
                new int[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 1, 0, 0 }
                }));
    }
}
