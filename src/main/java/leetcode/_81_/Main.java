package leetcode._81_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(solution.search(nums, 2));
        System.out.println(solution.search(nums, 5));
        System.out.println(solution.search(nums, 6));
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 1));
        System.out.println(solution.search(nums, 2));
        int[] nums2 = {2,5,6,0,0,1,2};
        System.out.println(solution.search(nums2, 3));
    }
}

