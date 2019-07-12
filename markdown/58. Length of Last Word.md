### [58\. Length of Last Word](https://leetcode.com/problems/length-of-last-word/)

Difficulty: **Easy**


Given a string _s_ consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

**Note:** A word is defined as a character sequence consists of non-space characters only.

**Example:**

```
Input: "Hello World"
Output: 5
```


#### Solution

Language: **Java**

```java
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
```
![](http://ww1.sinaimg.cn/large/006tNc79ly1g4xg3lcobsj31bk0s2gqt.jpg)