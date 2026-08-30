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

    public void flatten(TreeNode root) {
        List<TreeNode> res = result(root);
        if(root==null){
            return;
        }
        for (int i = 0; i < res.size() - 1; i++) {

    TreeNode current = res.get(i);
    TreeNode next = res.get(i + 1);
current.left  = null;
current.right = next;
}
 TreeNode last = res.get(res.size() - 1);
        last.left = null;
        last.right = null;
        
    }
    public List result(TreeNode root){
         List<TreeNode> res=new LinkedList<>();
       traverse(root,res);
       return res;
        

    }
    public void traverse(TreeNode root,List<TreeNode>res){
        if(root==null){
            return;
        }
        res.add(root);
        traverse(root.left,res);
        traverse(root.right,res);
    }
}