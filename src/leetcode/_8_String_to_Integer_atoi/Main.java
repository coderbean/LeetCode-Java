package leetcode._8_String_to_Integer_atoi;

/**
 * Created by zhangbo54 on 2019-03-01.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(" "));
        // Integer.parseInt("1" + Integer.MAX_VALUE);
    }

    static
    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            StringBuilder sb = null;
            boolean started = false;
            for (char c : str.toCharArray()) {
                if (started) {
                    if (c >= '0' && c <= '9') {
                        sb.append(c);
                    } else {
                        break;
                    }
                } else {
                    if (c == ' ') {
                        continue;
                    } else if ((c >= '0' && c <= '9') || c == '-' || c == '+') {
                        sb = new StringBuilder(Character.toString(c));
                        started = true;
                    } else {
                        return 0;
                    }
                }
            }
            if (!started) {
                return 0;
            }
            String resultStr = sb.toString();
            if (resultStr.equals("+") || resultStr.equals("-")) {
                return 0;
            }
            try {
                int result = Integer.parseInt(resultStr);
                return result;
            } catch (NumberFormatException e) {
                if (resultStr.startsWith("-")) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
    }
}
