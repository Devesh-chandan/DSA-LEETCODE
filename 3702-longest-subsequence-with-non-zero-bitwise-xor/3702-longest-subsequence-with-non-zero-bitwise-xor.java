class Solution {
    public int longestSubsequence(int[] nums) {
        int maxi=0;
        int n=nums.length;
        int xor=0;
        int sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
            sum+=nums[i];
        }
        if(xor>0){
            ans= n;
        }
        else if(xor==0 && sum==0){
ans= 0;
        }else{

        
       ans= n-1;
        }
        
        return ans;
    }
}