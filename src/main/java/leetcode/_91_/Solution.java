package leetcode._91_;

class Solution {
    public int numDecodings(String s) { // 动态规划
        if (s.startsWith("0")) {
            return 0;
        }
        return this.numDecodings(s.toCharArray(), s.length(), new int[s.length()]);
    }

    private int numDecodings(char[] chars, int length, int[] dp) {
        if (length <= 1) {
            return 1;
        }
        if (dp[length - 1] > 0) {
            return dp[length - 1];
        }
        int num = 0;
        if (chars[length - 1] != '0') {
            num += numDecodings(chars, length - 1, dp);
        } else {
            if (chars[length - 2] == '0') {
                dp[length - 1] = num;
                return num;
            }
        }
        if (chars[length - 2] != '0' && (chars[length - 2] - '0') * 10 + chars[length - 1] - '0' <= 26) {
            num += numDecodings(chars, length - 2, dp);
        }
        dp[length - 1] = num;
        return num;
    }
}