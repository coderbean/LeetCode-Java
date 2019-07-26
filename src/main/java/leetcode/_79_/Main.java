package leetcode._79_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(solution.exist(board,"ABCCED"));
        System.out.println(solution.exist(board,"SEE"));
        System.out.println(solution.exist(board,"ABCB"));
    }
}

