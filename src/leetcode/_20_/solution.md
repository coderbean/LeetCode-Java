### [20\. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

Difficulty: **Easy**


Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1.  Open brackets must be closed by the same type of brackets.
2.  Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**

```
Input: "()"
Output: true
```

**Example 2:**

```
Input: "()[]{}"
Output: true
```

**Example 3:**

```
Input: "(]"
Output: false
```

**Example 4:**

```
Input: "([)]"
Output: false
```

**Example 5:**

```
Input: "{[]}"
Output: true
```


#### Solution

Language: **Java**

```java
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
```
![](https://ws3.sinaimg.cn/large/006tKfTcgy1g0uh8bio97j30yo0u0jvz.jpg)