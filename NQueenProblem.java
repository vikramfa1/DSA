public class NQueenProblem {

    public static boolean solveNQUtil(int[][] board) {
        int[] left = new int[board.length];
        int[] lowerDg = new int[(board.length*2)-1];
        int[] upperDg = new int[(board.length*2)-1];
        return solveUtil(board, 0, left, lowerDg, upperDg);
    }

    private static boolean isSolvable(int[][] board, int row, int col, int[] left, int[] lowerDg, int[] upperDg) {
        return (left[row]!=1 && lowerDg[row + col]!=1 && upperDg[board.length+col-row-1]!=1);
    }
    private static boolean solveUtil(int[][] board, int col, int[] left, int[] lowerDg, int[] upperDg) {

        if(col>=board.length) {
            return true;
        }

        for(int row=0;row<board.length;row++) {
            if(isSolvable(board, row, col, left, lowerDg, upperDg)) {
                board[row][col] = 1;
                left[row] = 1;
                lowerDg[row + col] = 1;
                upperDg[board.length - row + col - 1] = 1;
                if (solveUtil(board, col + 1, left, lowerDg, upperDg)) {
                    return true;
                }
                    board[row][col] = 0;
                    left[row] = 0;
                    lowerDg[row + col] = 0;
                    upperDg[board.length - row + col - 1] = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] board = new int[][]{
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        if(solveNQUtil(board)) {
            System.out.println("queens can be formed");
            printBoard(board);
        } else {
            System.out.println("it cannot be solved");
        }
    }

    public static void printBoard(int[][] board) {
        for (int[] ints : board) {

            for (int j = 0; j < board.length; j++) {
                System.out.print(ints[j]+",");
            }
            System.out.println();
        }
    }
}
