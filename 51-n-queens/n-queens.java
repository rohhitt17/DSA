class Solution {
    public List<List<String>> solveNQueens(int n) {
         boolean[][] board = new boolean[n][n];
         List<List<String>> allSolutions = new ArrayList<>();
        nqueen(board, n, 0, allSolutions);
        return allSolutions;
    }
    public static void nqueen(boolean[][] board, int tq, int row, List<List<String>> allSolutions) {
        if (tq == 0) {
            allSolutions.add(boardToString(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (issafe(board, row, col)) {
                board[row][col] = true;
                nqueen(board, tq - 1, row + 1, allSolutions);
                board[row][col] = false;
            }
        }
    }

    private static boolean issafe(boolean[][] board, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (board[r][col]) return false;
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c]) return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c]) return false;
        }

        return true;
    }

    private static List<String> boardToString(boolean[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                row.append(board[i][j] ? 'Q' : '.');
            }
            res.add(row.toString());
        }
        return res;
    }
}