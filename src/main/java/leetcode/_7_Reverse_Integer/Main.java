package leetcode._7_Reverse_Integer;

/**
 * Created by zhangbo54 on 2019-03-01.
 */
public class Main {
    static
    class Solution {
        public int reverse(int x) {
            Long result = 0L;
            while (x != 0) {
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : result.intValue();
        }
    }
}


