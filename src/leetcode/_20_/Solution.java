package leetcode._20_;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        List<Character> left = Arrays.asList('(', '{', '[');
        List<Character> right = Arrays.asList(')', '}', ']');
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (left.contains(c)) {
                stack.push(left.indexOf(c));
            } else if (right.contains(c)) {
                if (stack.empty() || !stack.pop().equals(right.indexOf(c))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}