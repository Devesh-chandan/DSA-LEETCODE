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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         Stack<TreeNode> st=new Stack<>();
//         List<Integer> result=new ArrayList<Integer>();
       
//         TreeNode node=root;

//         while(true){
//            if(node!=null){
//             st.push(node);
//             node=node.left;

//            }else{
//             if(st.isEmpty()){
//                 break;
//             }
//             node=st.pop();
//             result.add(node.val);
//             node=node.right;

//            }

//         }
//         return result;

//     }
// }


//Optimal(Morris Traversal)         TC O(N) SC O(1)



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder=new ArrayList<Integer>();
        TreeNode curr=root;
        while(curr!=null){

            //CASE 1
            if(curr.left==null){
               inorder.add(curr.val);
               curr=curr.right; 
            }


            //CASE 2
            else{
                TreeNode prev=curr.left;
                while(prev.right!=null && prev.right!=curr ){
                    prev=prev.right;

                }
                if(prev.right==null){
                        prev.right=curr; //CREATE THRED POINTING TO CURR
                        curr=curr.left;
                }
                else{
                        prev.right=null; // REMOVE THE THREAD C REATED EARLIER
                        inorder.add(curr.val);
                        curr=curr.right;
                }
            }
        }
         
    return inorder;

    }
}