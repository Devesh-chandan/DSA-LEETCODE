
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int curr = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 1) {
                curr++;
                maxi = Math.max(maxi, curr);
            }
            else {
                curr = 0;
            }
        }

        return maxi;
    }
}