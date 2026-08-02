class Solution {
    public boolean predictTheWinner(int[] nums) {
       int i=0;
       int j=nums.length-1;
        int score1=solve(nums,i,j);
        int score2=0;
        int sum=0;
        for(int idx=0;idx<nums.length;idx++){
            sum+=nums[idx];
        }
        score2=sum-score1;
        if(score2>score1){
            return false;
        }
        return true;
        
    }
    public int solve(int[] nums,int i,int j){
        if (i > j) return 0;
        int take_i=nums[i]+Math.min(solve(nums,i+2,j),solve(nums,i+1,j-1));
        int take_j=nums[j]+Math.min(solve(nums,i+1,j-1),solve(nums,i,j-2));
        return Math.max(take_i,take_j);
    }
}