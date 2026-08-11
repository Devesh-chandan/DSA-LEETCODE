class Solution {
    public int missingInteger(int[] nums) {
       
        int sum=nums[0];
      
        for(int i=1;i<nums.length;i++){
           
                if(nums[i]==nums[i-1]+1){
                   
                    sum+=nums[i];
                }
                else{
                    break;
                }
            
           
       
            
        }
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int val:nums){
        if(!map.containsKey(val)){
            map.put(val,1);
        }
       }
       while(map.containsKey(sum)){
        sum++;
       }

        
return sum;
        
    }
}