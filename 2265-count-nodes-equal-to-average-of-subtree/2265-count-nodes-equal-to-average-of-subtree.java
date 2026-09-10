/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        // base case
        if(root==null){
            return new int[]{0, 0};
        }

        // get left information
        int[] left = dfs(root.left);

        // get right information
        int[] right = dfs(root.right);
        // calculate current sum and count
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        // check average
        if(sum/count==root.val){
            ans++;
        }
        return new int[]{sum, count};

        // return sum and count
    }
}