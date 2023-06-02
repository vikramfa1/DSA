package test1;

import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int x;
    int y;
    int steps;
    public Cell(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
    public String toString() {
        return x+","+y+","+steps;
    }
}
public class HorseTargetReach {

    private static boolean isValidCell(int N, int x, int y, boolean[][] visited) {
        if(x>=0 && y>=0 && x<N && y<N && !visited[x][y]) {
            return true;
        }
        return false;
    }
    public static int findStepsToReachTarget(int N, int[] knightPos, int[] targetPos) {
        boolean[][] visited = new boolean[N+1][N+1];
        int[] xPos = new int[] { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] yPos = new int[] { -1, -2, -2, -1, 1, 2, 2, 1 };
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(knightPos[0],knightPos[1],0));

        while(!queue.isEmpty()) {
            Cell curr = queue.poll();
            System.out.println("curr: "+curr);
            if(curr.x == targetPos[0] && curr.y == targetPos[1]) {
                return curr.steps;
            }
            if(visited[curr.x][curr.y]) {
                continue;
            } else {
                visited[curr.x][curr.y] = true;
                for (int i = 0; i < xPos.length; i++) {
                    int newXpos = curr.x + xPos[i];
                    int newYpos = curr.y + yPos[i];

                    if (isValidCell(N, newXpos, newYpos, visited)) {
                        queue.add(new Cell(newXpos, newYpos, curr.steps + 1));
                    }
                }
            }
        }
    return -1;
    }
    public static void main(String args[]) {
        int N = 30;
        int knightPos[] = { 1, 1 };
        int targetPos[] = { 30, 30 };
        int result = findStepsToReachTarget(N, knightPos, targetPos);
        System.out.println("result: "+result);

    }
}
