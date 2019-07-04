package leetcode._38_;

class Solution {
    public String countAndSay(int n) {
        String tmp = "1";
        if (n == 1) {
            return tmp;
        }
        for (int i = 1; i < n; i++) {
            tmp = say(tmp);
        }
        return tmp;
    }

    private String say(String numStr) {
        char tmp = numStr.charAt(0);
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) == numStr.charAt(i - 1)) {
                counter++;
            } else {
                sb.append(counter).append(tmp);
                tmp = numStr.charAt(i);
                counter = 1;
            }
        }
        sb.append(counter).append(tmp);
        return sb.toString();
    }
}