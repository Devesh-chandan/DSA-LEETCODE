// Brute force approach TC O(N2)
// class Solution {
//     public long[] distance(int[] nums) {
//         long[] arr = new long[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             int sum = 0;
//             for (int j = 0; j < nums.length; j++) {
//                 if (nums[i] == nums[j] && j != i) {
//                     sum += Math.abs(i - j);
//                 } else {
//                     sum += 0;
//                 }
//             }
//             arr[i] = sum;
//         }
//         return arr;

//     }
// }

class Solution {
    public long[] distance(int[] nums) {

        long[] res =new long[nums.length];
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           
            map.computeIfAbsent(nums[i],k->new ArrayList<Integer>()).add(i);
            
        }
        for(List<Integer> list:map.values()){
            long[] prefix=new long[nums.length];
            int size=list.size();
            prefix[0]=list.get(0);
            for(int i=1;i<size;i++){
                prefix[i]=prefix[i-1]+list.get(i);
                
            }
            for(int i=0;i<size;i++){
            long left=0;
            if(i>0){
                left=(long)list.get(i)*i-prefix[i-1];
            }
            long right=0;
            if(i<size-1){
                right=(prefix[size-1]-prefix[i])-(long)list.get(i)*(size-i-1);
            }
            res[list.get(i)]=left+right;
            }
            
              
        }
          return res;
    }
}