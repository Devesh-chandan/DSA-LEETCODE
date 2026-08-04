class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
       int max = Arrays.stream(nums).max().getAsInt();
       int min= Arrays.stream(nums).min().getAsInt();
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int val:nums){
        if(!map.containsKey(val)){
            map.put(val,1);
        }
       }
      for(int i=min;i<max;i++){
        if(!map.containsKey(i)){
            ans.add(i);
        }
      }
      return ans;

    }
}