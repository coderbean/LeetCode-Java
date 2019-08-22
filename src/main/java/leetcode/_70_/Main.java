package leetcode._70_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = System.currentTimeMillis();
        // System.out.println( solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(1));
        System.out.println("-----------------");
        System.out.println(solution.climbStairs(40));
        System.out.println(System.currentTimeMillis() - l);
    }
}

// 1
//         2
//         3
//         1
//         165580141
