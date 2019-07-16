package leetcode._63_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = {{0, 1, 1}, {1, 1, 1}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        int[][] obstacleGridw = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGridw));
        int[][] obstacleGridwq = {{0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGridwq));
        int[][] obstacleGridwq2 = {{1}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGridwq2));
    }
}

