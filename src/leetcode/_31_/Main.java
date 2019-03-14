package leetcode._31_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 3, 4, 5, 2};
        solution.nextPermutation(ints);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}

