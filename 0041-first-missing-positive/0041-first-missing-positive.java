import java.util.Arrays;


// BRUTE FORCE O(nlogn) 


// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         // Arrays.sort(nums);

//         // int res = 1;

//         // for (int i = 0; i < nums.length; i++) {
//         //     if (nums[i] == res) {
//         //         res++;
//         //     } else if (nums[i] > res) {
//         //         return res;
//         //     }
//         // }

//         // return res;
//     }
// }



// OPTIMIZED CODE   O(N)  O(1)

class Solution {
    public int firstMissingPositive(int[] nums) {
      int trash=100;
      int n=nums.length;
      for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
      for(int i=0;i<nums.length;i++){
        int num=Math.abs(nums[i]);
        if(num>nums.length){
            continue;
        }
        if(nums[num-1]>0){
        nums[num-1]=-nums[num-1];
        }

      }
      for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            return i+1;
        }
      }
      return nums.length+1;
    }
}