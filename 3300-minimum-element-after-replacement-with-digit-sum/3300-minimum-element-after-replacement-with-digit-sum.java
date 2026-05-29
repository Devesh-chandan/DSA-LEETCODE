class Solution {
    public int minElement(int[] nums) {
        int minsum=10000;
       
        for(int i=0;i<nums.length;i++){
           int num=nums[i];
           int sum=0;
           while(num>0){
           sum+=num%10;
            num/=10;
           }
minsum=Math.min(sum,minsum);
        }
        return minsum;
    }
}