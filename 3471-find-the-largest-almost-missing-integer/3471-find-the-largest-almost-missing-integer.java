class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] first = new int[51];
        int[] last = new int[51];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            first[x] = Math.min(first[x], i);
            last[x] = i;
        }

        int totalWindows = n - k + 1;
        int ans = -1;

        for (int x = 0; x <= 50; x++) {
            if (last[x] == -1) {
                continue;
            }

            int before = Math.max(0, first[x] - k + 1);
            int after = Math.max(0, n - k - last[x]);

            int windowsContaining = totalWindows - before - after;

            if (windowsContaining == 1) {
                ans = x;
            }
        }

        return ans;
    }
}