class Solution {
    public int maxProduct(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int maxi=nums[0];
        for(int i=1;i<nums.length;i++){
            int newMax = Math.max(nums[i],
                    Math.max(currmin*nums[i], currmax*nums[i]));

            int newMin = Math.min(nums[i],
                    Math.min(currmin*nums[i], currmax*nums[i]));

            currmax = newMax;
            currmin = newMin;
             maxi=Math.max(maxi,currmax);
        }
       
        return maxi;
        
    }
}