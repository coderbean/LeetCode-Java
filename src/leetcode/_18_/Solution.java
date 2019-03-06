package leetcode._18_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangbo54 on 2019-03-05.
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(); // 一开始写的是list，不过这个去重真的是很麻烦，还是使用set来去重了
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int targetSum = target - (nums[i] + nums[j]);
                if (targetSum < nums[j] && nums[j] > 0) { // 因为已经排序了，所以后面的任意两个数和必然大于 targetSum
                    break;
                }
                for (int x = j + 1, y = nums.length - 1; x < y; ) {
                    if (nums[x] + nums[y] > targetSum) {
                        y--;
                    } else if (nums[x] + nums[y] < targetSum) {
                        x++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        x++;
                        y--;

                        while (x < y && x >= 1 && nums[x] == nums[x - 1]) {
                            x++;
                        }
                        while (x < y && y + 1 < nums.length && nums[y] == nums[y + 1]) {
                            y--;
                        }
                    }
                }

            }
        }
        return new ArrayList<>(result);
    }
}

// [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]