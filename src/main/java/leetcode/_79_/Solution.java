package leetcode._79_;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int rows = board.length;
        int width = board[0].length;
        int[][] occupied = new int[rows][width];
        char[] chars = word.toCharArray();
        char firstChar = chars[0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == firstChar) {
                    occupied[i][j] = 1;
                    if (existSubStr(board, occupied, chars, 1, i, j)) {
                        return true;
                    } else {
                        occupied[i][j] = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean existSubStr(char[][] board, int[][] occupied, char[] chars, int startIndex, int i, int j) {
        if (startIndex >= chars.length) {
            return true;
        }
        char aChar = chars[startIndex];
        if (i + 1 < board.length && board[i + 1][j] == aChar && occupied[i + 1][j] == 0) {
            occupied[i + 1][j] = 1;
            if (existSubStr(board, occupied, chars, startIndex + 1, i + 1, j)) {
                return true;
            } else {
                occupied[i + 1][j] = 0;
            }
        }

        if (i - 1 >= 0 && board[i - 1][j] == aChar && occupied[i - 1][j] == 0) {
            occupied[i - 1][j] = 1;
            if (existSubStr(board, occupied, chars, startIndex + 1, i - 1, j)) {
                return true;
            } else {
                occupied[i - 1][j] = 0;
            }
        }


        if (j + 1 < board[0].length && board[i][j + 1] == aChar && occupied[i][j + 1] == 0) {
            occupied[i][j + 1] = 1;
            if (existSubStr(board, occupied, chars, startIndex + 1, i, j + 1)) {
                return true;
            } else {
                occupied[i][j + 1] = 0;
            }
        }

        if (j - 1 >= 0 && board[i][j - 1] == aChar && occupied[i][j - 1] == 0) {
            occupied[i][j - 1] = 1;
            if (existSubStr(board, occupied, chars, startIndex + 1, i, j - 1)) {
                return true;
            } else {
                occupied[i][j - 1] = 0;
            }
        }
        return false;
    }
}