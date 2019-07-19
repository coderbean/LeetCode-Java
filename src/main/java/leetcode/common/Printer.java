package leetcode.common;

/**
 * Created by zhangbo54 on 2019-07-19.
 */
public class Printer {
    public static void printArrays(int[] arrays) {
        if (arrays == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arrays.length - 1; i++) {
            System.out.print(arrays[i] + ",");
        }
        System.out.print(arrays[arrays.length - 1] + "]");
    }
}
