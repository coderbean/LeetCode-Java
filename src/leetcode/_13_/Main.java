package leetcode._13_;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
        // Integer.parseInt("1" + Integer.MAX_VALUE);
    }

    static
    class Solution {
        public int romanToInt(String s) {
            int result = 0;
            List<String> M = Arrays.asList("MMM", "MM", "M");
            List<String> C = Arrays.asList("CM", "DCCC", "DCC", "DC", "D", "CD", "CCC", "CC", "C");
            List<String> X = Arrays.asList("XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X");
            List<String> I = Arrays.asList("IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I");
            List<List<String>> list = Arrays.asList(M, C, X, I);
            int size = 1000;
            for (List<String> item : list) {
                for (int i = 0; i < item.size(); i++) {
                    if (s.startsWith(item.get(i))) {
                        result += (item.size() - i) * size;
                        s = s.substring(item.get(i).length());
                    }
                }
                size /= 10;
            }
            return result;
        }
    }
}
