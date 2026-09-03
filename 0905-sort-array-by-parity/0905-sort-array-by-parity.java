// NOT OPTIMIZED SC O(1)   TC O(N)


// class Solution {
//     public int[] sortArrayByParity(int[] nums) {
//         int ans[]=new int[nums.length];
//         ArrayList<Integer> res=new ArrayList<>();
//         for(int i=0;i<nums.length;i++){
// if(nums[i]%2==0){
//    res.add(nums[i]);
// }
//         }
//         for(int i=0;i<nums.length;i++){
// if(nums[i]%2!=0){
//    res.add(nums[i]);
// }
//         }
// for(int i=0;i<res.size();i++){
// ans[i]=res.get(i);
// }

// return ans;
        
//     }
// }

// OPTIMIZED SC O(1)   TC O(N)

class Solution {
    public int[] sortArrayByParity(int[] nums) {
      
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(left<right && nums[left]%2==0){
                left++;
            }
            if(left<right && nums[right]%2!=0){
                right--;
            }


            if(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return nums;
    }
}