package leetcode._13_;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
        // Integer.parseInt("1" + Integer.MAX_VALUE);
    }

    static
    class Solution {
        public int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = getInt(s.charAt(i));
                if (i + 1 < s.length() && getInt(s.charAt(i + 1)) > getInt(s.charAt(i))) {
                    result -= cur;
                } else {
                    result += cur;
                }
            }
            return result;
        }

        private int getInt(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}
