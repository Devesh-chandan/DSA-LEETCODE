class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        // Base case
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // Length of current subarray
        for (int len = 2; len <= n; len++) {

            for (int left = 0; left <= n - len; left++) {

                int right = left + len - 1;

                int takeLeft = nums[left] - dp[left + 1];
                int takeRight = nums[right] - dp[left];

                dp[left] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0] >= 0;
    }
}