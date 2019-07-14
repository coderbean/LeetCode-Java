package leetcode._60_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        List<Integer> leftNumList = new ArrayList<>();
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            leftNumList.add(i);
            sum *= i;
            factorial[i] = sum;
        }
        StringBuilder stringBuilder = new StringBuilder();
        k--; // Amazing k--
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            k = k % factorial[n - i];
            stringBuilder.append(leftNumList.get(index));
            leftNumList.remove(index);
        }
        return stringBuilder.toString();
    }
}