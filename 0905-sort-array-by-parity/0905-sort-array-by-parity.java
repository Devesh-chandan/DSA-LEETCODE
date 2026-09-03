class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ans[]=new int[nums.length];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
if(nums[i]%2==0){
   res.add(nums[i]);
}
        }
        for(int i=0;i<nums.length;i++){
if(nums[i]%2!=0){
   res.add(nums[i]);
}
        }
for(int i=0;i<res.size();i++){
ans[i]=res.get(i);
}

return ans;
        
    }
}