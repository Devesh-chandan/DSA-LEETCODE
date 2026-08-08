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
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        path(root);
        return maxi;

    }

    public int path(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = Math.max(0, path(root.left));
        int rightsum = Math.max(0, path(root.right));
        maxi = Math.max(maxi, (root.val + leftsum + rightsum));
        return root.val + Math.max(leftsum, rightsum);
    }
}