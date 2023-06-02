package test1;

import java.util.ArrayList;
import java.util.List;

public class FormIsland {

    private static List<int[]> formIsland(int[][] field) {
        List<int[]> finalList = new ArrayList<>();
        boolean[][] visited = new boolean[field.length][field.length];
        for(int row=0;row<field.length;row++) {
            for(int col=0;col<field.length;col++){
                if(field[row][col]==1 && !visited[row][col]) {
                    int[] res = findCoordinates(field, row, col, visited);
                    finalList.add(new int[]{row, col, res[0],res[1]});
                }
            }
        }
        return finalList;
    }

    private static int[] findCoordinates(int[][] field, int row, int col, boolean[][] visited) {
        if(row<0 || col<0 || row>= field.length || col>=field.length || field[row][col]==0 || visited[row][col]) {
            return new int[]{0,0};
        }
        visited[row][col]=true;
        int dr = row; int dc = col;
        int[] res = findCoordinates(field, row, col+1, visited);
        dr = Math.max(dr, res[0]);
        dc = Math.max(dc, res[1]);
        res = findCoordinates(field, row+1, col, visited);
        dr = Math.max(dr, res[0]);
        dc = Math.max(dc, res[1]);
        return new int[]{dr,dc};
    }

    public static void main(String args[]) {
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        formIsland(land).forEach(a -> System.out.println("res: "+a[0]+","+a[1]+","+a[2]+","+a[3]));
    }
}
