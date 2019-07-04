package leetcode._26_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 2};
        System.out.println(solution.removeDuplicates(a));
        System.out.println(a);
        // int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // System.out.println(solution.removeDuplicates(a));
        // for (int i : a) {
        //     System.out.println(i);
        // }
    }
}

