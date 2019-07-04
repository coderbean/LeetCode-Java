package leetcode._40_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target == candidates[i]) {
                result.add(Collections.singletonList(target));
            }
            for (List<Integer> list : this.combinationSum2(candidates, i, target - candidates[i])) {
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return new ArrayList<>(result);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target < candidates[index]) {
            return result;
        }
        if (Arrays.binarySearch(candidates, index + 1, candidates.length, target) > 0) {
            result.add(new ArrayList<>(Collections.singletonList(target)));
        }
        for (int i = index + 1; i < candidates.length; i++) {
            for (List<Integer> list : this.combinationSum2(candidates, i, target - candidates[i])) {
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return result;
    }
}