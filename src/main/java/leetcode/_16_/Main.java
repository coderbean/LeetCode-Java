package leetcode._16_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));

        // Integer.parseInt("1" + Integer.MAX_VALUE);
        //  -4 -1, -1, 0, 1, 2,
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums.length < 3) {
            return sum;
        }
        Arrays.sort(nums);
        int minGap = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                continue;
            }
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int numSum = target - nums[i];
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y ) {
                int tempSum = nums[x] + nums[y];
                if (tempSum == numSum) {
                    return target;
                } else {
                    if (Math.abs(minGap) > Math.abs(tempSum - numSum)) {
                        minGap = tempSum - numSum;
                    }
                    if (tempSum > numSum) {
                        y--;
                    } else {
                        x++;
                    }
                }
            }
        }
        return minGap + target;
    }
}