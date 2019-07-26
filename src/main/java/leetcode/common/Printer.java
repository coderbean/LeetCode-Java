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
        System.out.println();
    }

    public static void printArrays(int[][] arrays) {
        if (arrays == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[\n");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print("\t[");
            for (int j = 0; j < arrays[0].length; j++) {
                System.out.print(arrays[i][j]);
                if (j != arrays[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
