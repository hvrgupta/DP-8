// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int cnt = 0;
        int n = nums.length;
        int prev = 0;
        int curr = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = 1 + prev;
                cnt += curr;
            } else {
                curr = 0;
            }
            prev = curr;
        }

        return cnt;
    }
}