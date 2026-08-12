class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
    int start=0;
    
    int max=0;
    HashMap<Integer,Integer> map=new HashMap<>();
for (int end = 0; end < nums.length; end++) {

    
      map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
    while (map.get(nums[end]) > k) {
         map.put(nums[start], map.get(nums[start]) - 1);
                start++;
    }

max = Math.max(max, end - start + 1);



}
return max;
    }
}