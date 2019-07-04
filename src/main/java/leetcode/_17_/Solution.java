package leetcode._17_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-05.
 */
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
