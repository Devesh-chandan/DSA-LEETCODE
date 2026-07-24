class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=sorted(nums1,m,nums2,n);
        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
        
        
    }
    public int[] sorted(int[] nums1,int m,int[]nums2,int n){
        int[] merged=new int[m+n];
        ArrayList<Integer> nums=new ArrayList<>();
        for(int i=0;i<m;i++){
            nums.add(nums1[i]);
        }
        for(int j=0;j<n;j++){
            nums.add(nums2[j]);
        }
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
        for(int k=0;k<nums.size();k++){
            merged[k]=nums.get(k);
        }
        return merged;

    }
}