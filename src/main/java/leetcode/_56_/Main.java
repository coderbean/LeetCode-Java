package leetcode._56_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {8, 10}, {15, 18}, {2, 6}};
        // int[][] merge = solution.merge(intervals);
        // System.out.println(merge);
        int[][] intervals2 = {{1, 4}, {1, 4}};
        solution.merge(intervals2);
    }
}

