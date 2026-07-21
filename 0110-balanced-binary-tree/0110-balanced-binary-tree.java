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
    public boolean isBalanced(TreeNode root) {
       if(root==null){
            return true;

        }
        int leftdepth=depth(root.left);
        int rightdepth=depth(root.right);
        int diff=Math.abs(leftdepth-rightdepth);
        if(diff>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
        
        
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftmax=depth(root.left);
        int rightmax=depth(root.right);
        return 1+Math.max(leftmax,rightmax);
    }
    
    
}

