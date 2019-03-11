package leetcode._27_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0,1,2,2,3,0,4,2};
        // int[] ints = {3, 2, 2, 3};
        int i = solution.removeElement(ints, 2);
        System.out.println(i);
    }
}

