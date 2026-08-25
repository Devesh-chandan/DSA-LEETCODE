class Solution {
    public int missingMultiple(int[] nums, int k) {
      
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        int num=k;
        for(int val:set ){
          
            while(set.contains(num)){
                num+=k;
            }
           
        }
   return num;


// for(int i=0;i<nums.length;i++){
//     set.add(nums[i]);

// }
// int ans=0;
// for(int i=1;i<1000;i++){
//     if(!set.contains(k*i)){
//         ans=k*i;
//         break;
//     }

// }
// return ans;
}
}