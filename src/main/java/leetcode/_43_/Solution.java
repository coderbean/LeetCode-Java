package leetcode._43_;

import java.math.BigDecimal;

class Solution {
    public String multiply(String num1, String num2) {
        return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
    }
}