package leetcode._90_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        result.add(elem);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int dupCount = 0;
            while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
                dupCount++;
                i++;
            }
            int size = result.size();
            for (int j = 0; j < size; j++) {
                elem = new ArrayList<>(result.get(j));
                for (int k = 0; k <= dupCount; k++) {
                    elem.add(nums[i]);
                    result.add(new ArrayList<>(elem)); // 注意这里是要放在 for 循环里面的
                }
            }
        }
        return result;
    }
}