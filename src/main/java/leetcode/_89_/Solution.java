package leetcode._89_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) { // 从尾部开始，用于保持连续（即每次只差一个bit位）
                result.add(result.get(j) | 1 << i);
            }
        }
        return result;
    }
}