package leetcode._36_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> hList = new ArrayList<>(27);
        List<Set<Character>> vList = new ArrayList<>(27);
        for (int i = 0; i < 27; i++) {
            hList.add(new HashSet<>());
            vList.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int vIndex = i + j / 3 * 9;
                int hIndex = j + i / 3 * 9;
                if (board[i][j] != '.') {
                    if (hList.get(hIndex).contains(board[i][j]) || vList.get(vIndex).contains(board[i][j])) {
                        return false;
                    }
                    hList.get(hIndex).add(board[i][j]);
                    vList.get(vIndex).add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            // every row
            Set<Character> set = new HashSet<>();
            set.addAll(vList.get(i));
            set.addAll(vList.get(i + 9));
            set.addAll(vList.get(i + 9 * 2));
            if (set.size() != (vList.get(i).size() + vList.get(i + 9).size() + vList.get(i + 9 * 2).size())) {
                return false;
            }

            // every columns
            Set<Character> set2 = new HashSet<>();
            set2.addAll(hList.get(i));
            set2.addAll(hList.get(i + 9));
            set2.addAll(hList.get(i + 9 * 2));
            if (set2.size() != (hList.get(i).size() + hList.get(i + 9).size() + hList.get(i + 9 * 2).size())) {
                return false;
            }

            // every little 9 grips
            Set<Character> set3 = new HashSet<>();
            set3.addAll(vList.get(i * 3));
            set3.addAll(vList.get(i * 3 + 1));
            set3.addAll(vList.get(i * 3 + 2));
            if (set3.size() != (vList.get(i * 3).size() + vList.get(i * 3 + 1).size() + vList.get(i * 3 + 2).size())) {
                return false;
            }

        }
        return true;
    }
}