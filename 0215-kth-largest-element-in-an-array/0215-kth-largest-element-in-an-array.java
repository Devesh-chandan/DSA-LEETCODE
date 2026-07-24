
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Brute force O(nlogn);
        //  Arrays.sort(nums);
        //  return nums[nums.length-k];


        //optimal code O(nlogk)
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
        
        
    }
}