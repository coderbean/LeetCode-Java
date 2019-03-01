package leetcode._9_Palindrome_Number;

/**
 * Created by zhangbo54 on 2019-03-01.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1));
        // Integer.parseInt("1" + Integer.MAX_VALUE);
    }

    static
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            char[] charArray = String.valueOf(x).toCharArray();
            for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
                if (charArray[i] != charArray[j]) {
                    return false;
                }
            }
            return true;
        }
    }
}
