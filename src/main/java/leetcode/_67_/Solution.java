package leetcode._67_;

class Solution {
    public String addBinary(String a, String b) {
        char[] shortStr;
        char[] longStr;
        if (a.length() > b.length()) {
            shortStr = b.toCharArray();
            longStr = a.toCharArray();
        } else {
            shortStr = a.toCharArray();
            longStr = b.toCharArray();
        }
        int plusNum = 0;
        int i = longStr.length - 1;
        int j = shortStr.length - 1;
        do {
            int sum = longStr[i] - '0' + plusNum;
            if (j >= 0) {
                sum += (shortStr[j] - '0');
            }
            longStr[i] = (char) (sum % 2 + '0');
            plusNum = sum / 2;
            i--;
            j--;
        } while (i >= 0);
        if (plusNum > 0) {
            return "1" + String.valueOf(longStr);
        } else {
            return String.valueOf(longStr);
        }
    }
}