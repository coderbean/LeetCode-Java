### [22\. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

Difficulty: **Medium**


Given _n_ pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given _n_ = 3, a solution set is:

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        traceBack(result, "", n, n);
        return result;
    }
​
    private void traceBack(List<String> result, String curStr, int left, int rigth) {
        if (left == 0 && rigth == 0) {
            result.add(curStr);
            return;
        }
        if (left > rigth) { // 如果 剩余的 右括号比比左括号 少，说明 当前 str 的右括号多，无法匹配，不再递归
            return;
        }
        if (left >= 0) {
            traceBack(result, curStr + '(', left - 1, rigth);
        }
        if (rigth >= 0) {
            traceBack(result, curStr + ')', left, rigth - 1);
        }
    }
}
        if (rigth >= 0) {
```

![](https://ws1.sinaimg.cn/large/006tKfTcgy1g0vm0gawoyj30wx0u0wj1.jpg)