package leetcode._47_;

import java.util.HashSet;
import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
        System.out.println(solution.permuteUnique(nums).size());
        HashSet<List<Integer>> set = new HashSet<>(solution.permuteUnique(nums));
        System.out.println(set.size());
    }
}

