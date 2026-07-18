class Solution {
    public int findGCD(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<smallest){
                smallest=nums[i];

            }
            if(nums[i]>largest){
                largest=nums[i];
            }
        }
        return gcd(smallest,largest);

    }
    public int gcd(int a , int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}