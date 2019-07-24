package nowcoder;

import java.util.Scanner;


/**
 * Created by jacob on 2019-07-24.
 */
public class LCS2 {
    public static void main(String[] args) {
        LCS2 main = new LCS2();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(" ");
            System.out.println(main.longestCommonSequence(strings[0], strings[1]));
        }
    }


    private int longestCommonSequence(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return 0;
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (aChars[i] == bChars[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}