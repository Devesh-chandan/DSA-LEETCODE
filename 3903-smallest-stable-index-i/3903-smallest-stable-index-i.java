class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currmax = nums[0];
            for (int j = 0; j <= i; j++) {
                currmax = Math.max(currmax, nums[j]);
            }
            int currmin = nums[i];
            for (int j = i; j < n; j++) {
                currmin = Math.min(currmin, nums[j]);
            }
            if (currmax - currmin <= k) {
                return i;
            }

        }
        return -1;
    }
}