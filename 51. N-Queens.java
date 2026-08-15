class Solution {

    static void solve( char[][] board, int n, int colIndex, List<List<String>> ans){
        //base case
        if(colIndex >= n){
            //that means we got valid arrangement on board
            //store this valid arrangement in ans
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n ; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        // 1case we'll solve other recursion will take care other cases
        //current column ke har cell pe jakar ya fir current column ke har row par jaakr 
        //queen place karunga and rest recursion ko de dunga solve karne ke liye

        for (int rowIndex  = 0; rowIndex  < n; rowIndex ++) {
            if(isSafeToPlace(rowIndex,colIndex,n,board)){
                //place queen
                board[rowIndex][colIndex] = 'Q';
                //baki recursion
                solve(board,n,colIndex+1,ans);

                //back Tracking step
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    private static boolean isSafeToPlace(int rowIndex, int colIndex , int n , char[][] board) {
        //check left horizontal
        int row = rowIndex;
        int col = colIndex;

        while (col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            //no need to change in row index
            //value of `col index will travel till zero
            col--;
        }

        //check left upper diagonal
        row = rowIndex;
        col = colIndex;

        while (row >= 0 && col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }
            row = row - 1;
            col = col - 1;
        }

        //check left lower diagonal
        row = rowIndex;
        col = colIndex;

        while (row < n && col >= 0){
            if (board[row][col] == 'Q'){
                return false;
            }

            row = row+1;
            col = col -1;
        }
        return true;
    }

    static List<List<String>> solveNQueens(int n){
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i],'.');
        }
        int colIndex = 0;

        List<List<String>> ans = new ArrayList<>();
        solve(board,n,colIndex,ans);
        return ans;
        
    }
}
