// TC=O((m+n)log(m+n))
// SC=O(m+n)

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         // int[] ans=sorted(nums1,m,nums2,n);
//         // for (int i = 0; i < m + n; i++) {
//         //     nums1[i] = ans[i];
//         // }

//     }
//     public int[] sorted(int[] nums1,int m,int[]nums2,int n){
//         int[] merged=new int[m+n];
//         ArrayList<Integer> nums=new ArrayList<>();
//         for(int i=0;i<m;i++){
//             nums.add(nums1[i]);
//         }
//         for(int j=0;j<n;j++){
//             nums.add(nums2[j]);
//         }
//         System.out.println(nums);
//         Collections.sort(nums);
//         System.out.println(nums);
//         for(int k=0;k<nums.size();k++){
//             merged[k]=nums.get(k);
//         }
//         return merged;

//     }
// }



// Approach 2 O(m+n)
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int ans[] = sorted(nums1, m, nums2, n);
//         for (int i = 0; i < m + n; i++) {
//             nums1[i] = ans[i];
//         }

//     }

//     public int[] sorted(int[] nums1, int m, int[] nums2, int n) {
//         int[] sorted = new int[m + n];
//         int i = 0;
//         int j = 0;
//         int k = 0;

//         while (i < m && j < n) {

//             if (nums1[i] <= nums2[j]) {
//                 sorted[k++] = nums1[i++];
//             } else {
//                 sorted[k++] = nums2[j++];
//             }
//         }

//         while (i < m)
//             sorted[k++] = nums1[i++];

//         while (j < n)
//             sorted[k++] = nums2[j++];
//         return sorted;
//     }

// }


// Approach 3 O()
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
              i--;
            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
 k--;

            }
           
            while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        }
}
