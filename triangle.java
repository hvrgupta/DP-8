// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    // tabulation
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];
        int i = 0;
        for (List<Integer> li : triangle) {
            dp[i] = new int[li.size()];
            i++;
        }

        int n = triangle.get(triangle.size() - 1).size();

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i + 1][j], triangle.get(i).get(j) + dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];

        // return helper(triangle,0,0,dp);
    }

    // memoization solution
    private int helper(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) + Math.min(helper(triangle, i + 1, j, dp),
                helper(triangle, i + 1, j + 1, dp));
    }
}