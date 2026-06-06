class Solution {
    public int jump(int[] nums) {
        int maxreach=0;
        int currentpos=0;
        int count=0;
       
            for(int i=0;i<nums.length-1;i++){
              maxreach=Math.max(maxreach,nums[i]+i);
              if(i==currentpos){
                count++;
                currentpos=maxreach;
              }
            
            }
        return count;

        
    }
}