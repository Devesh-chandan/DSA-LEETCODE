class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftsum=new int[nums.length];
        int[] rightsum=new int[nums.length];
        int[] result=new int[nums.length];
          int sumright=0;
          int sumleft=0;
        for(int i=0;i<nums.length;i++){
            
            leftsum[i]=sumleft;
            sumleft+=nums[i];

        }
        for(int j=nums.length-1;j>=0;j--){
          
            rightsum[j]=sumright;
            sumright+=nums[j];
        }
        for(int i=0;i<nums.length;i++){
            result[i]=Math.abs(leftsum[i]-rightsum[i]);

        }
        return result;
        
    }
}