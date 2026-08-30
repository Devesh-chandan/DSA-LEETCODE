class Solution {
    public int minimumDeletions(int[] nums) {
        int opr=1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int start=0;
        int end=nums.length;
        int minidx=0;
        int maxidx=0;
        int mid=start+(end-start)/2;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxidx=i;

            }
            if(nums[i]<min){
                min=nums[i];
                minidx=i;
            }
        }
        int left=Math.min(maxidx,minidx);
        int right=Math.max(minidx,maxidx);
        int A=right+1;
        int B=nums.length-left;
        int C=left+1+nums.length-right;
        return Math.min(A,Math.min(B,C));
       
        
    }
}