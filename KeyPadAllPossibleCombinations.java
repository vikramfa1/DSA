package test1.subsets;

import java.io.*;

public class KeyPadAllPossibleCombinations {

    int[] rowDirs = {-1,0,1,0};
    int[] colDirs = {0,-1,0,1};

    public int allPossibleCombinations(char[][] keypad) throws IOException {
        int count = allPossibleUtils(0, new char[6], keypad, 0,0);
        System.out.println("tot count: "+count);
        return count;
    }

    private int allPossibleUtils(int index, char[] chars, char[][] keypad, int row, int col) throws IOException {

        if(index>=6) {
            return 1;
        }
        int count=0;
        if(index ==0 || index ==5) {
            if (row == 3 || col == 0 || col == 2) {
                if (index == 0) {
                    chars[index] = '*';

                } else {
                    chars[index] = '#';
                }
                count+=allPossibleUtils(index + 1, chars, keypad, row, col);
            }
        }

        for(int r=0;r<4;r++) {
            if(isNotValid(index, r, col) || index>0 && chars[index-1] == keypad[r][col]) {
                continue;
            }
            chars[index] = keypad[r][col];
            count+=allPossibleUtils(index + 1, chars, keypad, r, col);
        }

        for(int c=0;c<3;c++) {
            if(isNotValid(index, row, c) || index>0 && chars[index-1] == keypad[row][c]) {
                continue;
            }
            chars[index] = keypad[row][c];
            count+=allPossibleUtils(index + 1, chars, keypad, row, c);
        }

        for(int d=0;d<4;d++) {
            int newRow = row+rowDirs[d];
            int newCol = col+colDirs[d];

            if(isNotValid(index, newRow, newCol)) {
                continue;
            }
            if(isValid(keypad, newRow, newCol)) {
                chars[index] = keypad[newRow][newCol];
                count+=allPossibleUtils(index + 1, chars, keypad, newRow, newCol);
            }
        }
        return count;
    }


    private boolean isNotValid(int index, int row, int col) {
        if((index!=0 && index!=5) && ((row==3 && col==0) || (row==3 && col==2))) {
            return true;
        }
        return false;
    }
    private boolean isValid(char[][] keypad, int row, int col) {
        if(row>=0 && row<4 && col>=0 && col<3) {
            return true;
        }

        return false;
    }
    public static void main(String args[]) throws IOException {

        char[][] keypad = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}};
        KeyPadAllPossibleCombinations obj = new KeyPadAllPossibleCombinations();
        System.out.println("result: "+ obj.allPossibleCombinations(keypad));

    }



    /*
    public int allPossibleCombinations(char[][] keypad) throws IOException {
        File f = new File("C:/Users/Dell/OneDrive/Documents/sample/output.txt");
        f.createNewFile();
        FileOutputStream oStream = new FileOutputStream(f);
        BufferedOutputStream bStream = new BufferedOutputStream(oStream);
        allPossibleUtils(0, new char[6], keypad, 0,0, bStream);
        bStream.flush();
        bStream.close();
        oStream.close();
        return -1;
    }

    private void allPossibleUtils(int index, char[] chars, char[][] keypad, int row, int col,  BufferedOutputStream stream) throws IOException {

        if(index>=6) {
            String s = new String(chars)+","+(++count);
            System.out.println(s);
            byte b[]=s.getBytes();
            stream.write(b);
            stream.write(System.lineSeparator().getBytes());
            stream.flush();
            return;
        }

        if(index ==0 || index ==5) {
            if (row == 3 || col == 0 || col == 2) {
                if (index == 0) {
                    chars[index] = '*';

                } else {
                    chars[index] = '#';
                }
                allPossibleUtils(index + 1, chars, keypad, row, col,stream);
            }
        }

        for(int r=0;r<4;r++) {
            if(isNotValid(index, r, col) || index>0 && chars[index-1] == keypad[r][col]) {
                continue;
            }
            chars[index] = keypad[r][col];
            allPossibleUtils(index + 1, chars, keypad, r, col,stream);
        }

        for(int c=0;c<3;c++) {
            if(isNotValid(index, row, c) || index>0 && chars[index-1] == keypad[row][c]) {
                continue;
            }
            chars[index] = keypad[row][c];
            allPossibleUtils(index + 1, chars, keypad, row, c,stream);
        }

        for(int d=0;d<4;d++) {
            int newRow = row+rowDirs[d];
            int newCol = col+colDirs[d];

            if(isNotValid(index, newRow, newCol)) {
                continue;
            }
            if(isValid(keypad, newRow, newCol)) {
                chars[index] = keypad[newRow][newCol];
                allPossibleUtils(index + 1, chars, keypad, newRow, newCol,stream);
            }
        }

    }
     */
}
