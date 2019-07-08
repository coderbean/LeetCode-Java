### [17\. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

Difficulty: **Medium**


Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

**Example:**

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Note:**

Although the above answer is in lexicographical order, your answer could be in any order you want.


#### Solution

Language: **Java**

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }
        if (digits.length() == 1) {
            return singleDigitToStringList(digits.charAt(0));
        }
        List<String> leftArr = this.letterCombinations(digits.substring(0, digits.length() / 2));
        List<String> rightArr = this.letterCombinations(digits.substring(digits.length() / 2));
        List<String> result = new ArrayList<>();
        for (String left : leftArr) {
            for (String right : rightArr) {
                result.add(left + right);
            }
        }
        return result;
    }
​
    private List<String> singleDigitToStringList(char digit) {
        switch (digit) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return Arrays.asList("");
        }
    }
}
​
```