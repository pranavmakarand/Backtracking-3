class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean value = backTrack(board, word, i, j, "", visited);
                if (value)
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int i, int j, String create, boolean[][] visited) {

        if (i < board.length && i >= 0 && j < board[0].length && j >= 0) {
            char ch = board[i][j];
            create += ch;
            visited[i][j] = true;
        }

        if (create.length() == word.length()) {
            visited[i][j] = false;
            if (create.equals(word)) {
                return true;
            }
            return false;
        }

        boolean right = false;
        boolean down = false;
        boolean up = false;
        boolean left = false;

        if (i < board.length && i >= 0 && j < board[0].length && j >= 0) {
            if ((j + 1 < board[0].length) && !visited[i][j+1])
                right = backTrack(board, word, i , j + 1, create, visited);
            if (!right && (i + 1 < board.length) && !visited[i + 1][j])
                down = backTrack(board, word, i + 1, j, create, visited);
            if (!down && (i - 1 >= 0) && !visited[i - 1][j])
                up = backTrack(board, word, i - 1, j, create, visited);
            if (!up && (j - 1 >= 0) && !visited[i][j-1])
                left = backTrack(board, word, i, j - 1, create, visited);
            
            visited[i][j] = false;
        }

        return right || down || up || left;
    }
}