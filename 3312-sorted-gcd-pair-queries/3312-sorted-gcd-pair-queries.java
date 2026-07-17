class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        // Find maximum
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Frequency array
        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        // gcdCount[g] = pairs having GCD exactly g
        long[] gcdCount = new long[max + 1];

        // Calculate exact GCD counts
        for (int g = max; g >= 1; g--) {

            int count = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }

            // All pairs where both numbers are divisible by g
            gcdCount[g] = (long) count * (count - 1) / 2;

            // Remove pairs having GCD as a larger multiple of g
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                gcdCount[g] -= gcdCount[multiple];
            }
        }

        // Prefix sum
        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdCount[g];
        }

        // Answer queries
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefix, queries[i]);
        }

        return ans;
    }


    private int binarySearch(long[] prefix, long query) {

        int left = 1;
        int right = prefix.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (prefix[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}