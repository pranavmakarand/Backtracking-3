class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> listQueen = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        helper(n, 0, board, listQueen);

        return listQueen;
    }

    private void helper(int n, int index, boolean[][] board,  List<List<String>> listQueen) {
        
        //Base case

        if (index == board.length) {
            List<String> ans = new ArrayList<String>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder build = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]) {
                        build.append("Q");
                    } else {
                        build.append(".");
                    }
                }
                ans.add(build.toString());
            }
            listQueen.add(ans);
            return;
        }
    
        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(index, j, board)) {
                board[index][j] = true;
                helper(n, index + 1, board, listQueen);
                board[index][j] = false;
            }
        }
    }

    private boolean isSafe(int i, int j, boolean[][] board) {
        
        boolean up = checkUp(i, j, board);
        boolean upRight = checkUpRight(i, j, board);
        boolean upLeft = checkUpLeft(i, j, board);

        return up && upRight && upLeft;
    }

    private boolean checkUp(int i, int j, boolean[][] board) {
        
        int c = j, r = i;

        while (r >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
        }

        return true;
    }

    private boolean checkUpRight(int i, int j, boolean[][] board) {
        
        int r = i, c = j;

        while (r >= 0 && c < board[0].length) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private boolean checkUpLeft(int i, int j, boolean[][] board) {
        int r = i, c = j;

        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        return true;
    }
}