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




 //Not optimal TC O(N) SC O(N)
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res=new ArrayList<>();
//         traverse(root,res);
//         return res;
        
        
//     }
//     public void traverse(TreeNode node,List<Integer> res){
//         if(node==null){
//             return;
//         }
//         res.add(node.val);
//         traverse(node.left,res);
//         traverse(node.right,res);
//     }
// }



//Optimal(Morris Traversal)         TC O(N) SC O(1)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> preorder=new ArrayList<>();

        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
preorder.add(curr.val);
curr=curr.right;
            }else{
TreeNode prev=curr.left;
while(prev.right!=null && prev.right!=curr){
    prev=prev.right;
}
                if(prev.right==null){
prev.right=curr;
preorder.add(curr.val);
curr=curr.left;
                }
                else{

prev.right=null;
curr=curr.right;
                }
            }
        }
        
        return preorder;
    }
}