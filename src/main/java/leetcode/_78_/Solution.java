package leetcode._78_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        result.add(item);
        for (int subSetSize = 1; subSetSize <= nums.length; subSetSize++) { // 这里的 subSetSize 表示这次生成的是几个元素的 set
            for (int x = 0; x < result.size(); x++) {
                List<Integer> list = result.get(x);
                if (subSetSize == list.size() + 1) { // 由于此次需要加入一个元素，所以需要将 size 为 subSetSize-1 的 list 拿出来处理
                    for (int j = list.size(); j < nums.length; j++) {
                        if ((list.size() == 0 || nums[j] > list.get(list.size() - 1))) { // 这里保证生成的 size 必须是升序的
                            List<Integer> newItem = new ArrayList<>(list);
                            newItem.add(nums[j]);
                            result.add(newItem);
                        }
                    }
                }
            }
        }
        return result;
    }
}