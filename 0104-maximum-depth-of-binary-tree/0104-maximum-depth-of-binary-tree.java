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
    public int maxDepth(TreeNode root) {
        TreeNode node=root;
       
        if(root==null){
            return 0;
        }
        int leftcount=maxDepth(root.left);
        int rightcount =maxDepth(root.right);



       
            int ht=1+Math.max(leftcount,rightcount);
            return ht;
                    }
        
    }
