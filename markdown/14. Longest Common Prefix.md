### [14\. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)

Difficulty: **Easy**


Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

**Example 1:**

```
Input: ["flower","flow","flight"]
Output: "fl"
```

**Example 2:**

```
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

**Note:**

All given inputs are in lowercase letters `a-z`.


#### Solution

Language: **Java**

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
​
        if (strs.length == 1) {
            return strs[0];
        }
        int minLenth = strs[0].length();
​
        for (String str : strs) {
            if (minLenth > str.length()) {
                minLenth = str.length();
            }
        }
​
        for (int longPrefixIndex = 0; longPrefixIndex < minLenth; longPrefixIndex++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(longPrefixIndex) != strs[j + 1].charAt(longPrefixIndex)) {
                    return strs[0].substring(0, longPrefixIndex);
                }
            }
        }
        return "";
    }
}
```