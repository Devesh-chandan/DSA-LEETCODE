class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        
        int[] ans=new int[nums.length];
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(arr1.getLast()>arr2.getLast()){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        ArrayList<Integer> merged=new ArrayList<>(arr1);
        merged.addAll(arr2);
        for(int i=0;i<ans.length;i++){
            ans[i]=merged.get(i);
        }
        return ans;
        
    }
}