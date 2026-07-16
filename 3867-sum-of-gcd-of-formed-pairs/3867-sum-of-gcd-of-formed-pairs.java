class Solution {
    public long gcdSum(int[] nums) {
        int maxi = -1;
        int[] prefixgcd = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // for (int j = i + 1; j < nums.length; j++) {
            //     // max = Math.max(max, nums[i]);
            //     prefixgcd[i] = gcd(max, nums[i]);
            // }
            maxi=Math.max(maxi,nums[i]);
            prefixgcd[i]=gcd(maxi,nums[i]);
        }
        long sum = 0;
      
        Arrays.sort(prefixgcd);
        int start = 0;
        int end = prefixgcd.length-1;
        while (end > start) {
            sum += gcd(prefixgcd[start], prefixgcd[end]);
            start++;
            end--;

        }
        return sum;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}