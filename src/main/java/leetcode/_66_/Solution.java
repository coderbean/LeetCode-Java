package leetcode._66_;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] result = {1};
            return result;
        }
        int plusNum = 1;
        for (int i = digits.length - 1; i >= 0 && plusNum > 0; i--) {
            int newNum = digits[i] + plusNum;
            plusNum = newNum / 10;
            digits[i] = newNum % 10;
        }
        if (plusNum > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = plusNum;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}