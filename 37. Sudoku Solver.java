class Solution {

    public static boolean findEmptyCell(char[][] board, int[] emptyCell) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //store row of empty cell
                    emptyCell[0] = i;

                    //store colIndex of empty cell
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        //didn't get any empty cell
        return false;
    }

    public static boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex) {

        //Rule 1
        //check same row
        //rowIndex for each cell will be same
        //and col index will move to 0 to <9

        for (int col = 0; col < 9; col++) {
            if (board[rowIndex][col] == charValue) {
                return false;
            }
        }

        //Rule 2
        //check same column
        //colIndex will be same for each cell
        //rowIndex will move from 0 t <9

        for (int row = 0; row < 9; row++) {
            if (board[row][colIndex] == charValue) {
                return false;
            }
        }

        //Rule 3
        //check current 3*3 sub box
        int startRow = rowIndex - rowIndex % 3;
        int startCol = colIndex - colIndex % 3;

        //travel over the 3*3 sub box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int actualRow = startRow + i;
                int actualCol = startCol + j;

                if (board[actualRow][actualCol] == charValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudokuHelper(char[][] board) {

        //base case
        //when there is no empty space inside the board then the problem is solved

        int[] emptyCell = new int[2];
        if (!findEmptyCell(board, emptyCell)) {
            return true;
        }
        //if found an empty cell
        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for (int value = 1; value <= 9; value++) {
            char charValue = (char) (value + '0');
            if (isSafeToPlace(board, charValue, rowIndex, colIndex)) {
                //place it
                board[rowIndex][colIndex] = charValue;
                //baaki recursion will take care

                if (solveSudokuHelper(board) == true) {
                    return true;
                }

                //agar recursion didn't solve / returned back
                //undo the current value /backtracking step

                board[rowIndex][colIndex] = '.';
            }
        }

        //not able to solve
        return false;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
}
