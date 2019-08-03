### [91\. Decode Ways](https://leetcode.com/problems/decode-ways/)

Difficulty: **Medium**


A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26
```

Given a **non-empty** string containing only digits, determine the total number of ways to decode it.

**Example 1:**

```
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
```

**Example 2:**

```
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
```


#### Solution A （推荐）

Language: **Java**

```java
class Solution {
    public int numDecodings(String s) { // 动态规划
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0 && first < 10) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
```


#### Solution B

Language: **Java**

```java
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
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-03-tX1fHU.jpg)