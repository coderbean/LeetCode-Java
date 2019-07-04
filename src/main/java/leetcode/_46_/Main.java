package leetcode._46_;

import java.util.HashSet;
import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.permute(nums));
        System.out.println(solution.permute(nums).size());
        HashSet<List<Integer>> set = new HashSet<>(solution.permute(nums));
        System.out.println(set.size());
    }
}

