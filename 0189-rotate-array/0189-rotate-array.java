class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;

        // Important when k > n
       k=k%n;

        int[] result = new int[n];

        // Put last k elements at beginning
        for (int i = n - k; i < n; i++) {
            result[i - (n - k)] = nums[i];
        }

        // Put remaining elements after k positions
        for (int i = 0; i < n - k; i++) {
            result[i + k] = nums[i];
        }

        // Copy result back to nums
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}
   