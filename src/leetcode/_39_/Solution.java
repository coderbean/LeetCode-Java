package leetcode._39_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> candidateSet = Arrays.stream(candidates).boxed().collect(Collectors.toCollection(TreeSet::new));
        return this.combinationSum(candidateSet, target);
    }

    // here def a new func to avoid calculate a new Set every time
    private List<List<Integer>> combinationSum(Set<Integer> candidateSet, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidateSet.contains(target)) {
            result.add(new ArrayList<>(Collections.singleton(target)));
        }
        for (Integer candidate : candidateSet) {
            int newTarget = target - candidate;
            if (newTarget < candidate) {
                return result;
            } else {
                for (List<Integer> list : this.combinationSum(candidateSet, newTarget)) {
                    // this ensure all result are desc sorted to avoid repetition
                    if (candidate <= list.get(list.size() - 1)) {
                        list.add(candidate);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}