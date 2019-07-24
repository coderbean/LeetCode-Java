package nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jacob on 2019-07-24.
 */
public class LCS {
    public static void main(String[] args) {
        LCS main = new LCS();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(" ");
            System.out.println(main.longestCommonSequence(strings[0], strings[1]));
        }
    }

    private Set<String> longestCommonSequence(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return null;
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
        } // 将二维数组的数据全部填充完毕

        Set<String> result = new HashSet<>();
        this.printCommonSequeue(aChars, bChars, dp, "", result, a.length(), b.length());
        return result;
    }

    private void printCommonSequeue(char[] aChars, char[] bChars, int[][] dp,
                                    String initStr, Set<String> result,
                                    int i, int j) {
        StringBuilder stringBuilder = new StringBuilder(initStr);
        while (i > 0 && j > 0) {
            if (aChars[i - 1] == bChars[j - 1]) {
                stringBuilder.append(aChars[i - 1]);
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else if (dp[i][j - 1] < dp[i - 1][j]) {
                    i--;
                } else {
                    this.printCommonSequeue(aChars, bChars, dp, stringBuilder.toString(), result, i - 1, j);
                    j--;
                }
            }
        }
        result.add(stringBuilder.reverse().toString());
    }
}
