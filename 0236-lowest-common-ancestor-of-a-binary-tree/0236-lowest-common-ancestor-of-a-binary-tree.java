/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Not optimal solution 
// class Solution {
//     private boolean getPath1(TreeNode root,ArrayList<Integer>arr1,TreeNode p){
//         if(root==null){
//             return false;
//         }
//         arr1.add(root.val);
//         if(root.val==p.val){
//             return true;
//         }
//         if(getPath1(root.left,arr1,p) || getPath1(root.right,arr1,p)){
//             return true;
//         }
//         arr1.remove(arr1.size()-1);
//         return false;

//     }
//     private boolean getPath2(TreeNode root,ArrayList<Integer>arr2,TreeNode q){
//          if(root==null){
//             return false;
//         }
//         arr2.add(root.val);
//         if(root.val==q.val){
//             return true;
//         }
//         if(getPath2(root.left,arr2,q) || getPath2(root.right,arr2,q)){
//             return true;
//         }
//         arr2.remove(arr2.size()-1);
//         return false;

//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode ans=root;
//         ArrayList<Integer> arr1=new ArrayList<>();
//         ArrayList<Integer> arr2=new ArrayList<>();
//         if(root==null){
//             return ans;
            
//         }
//         getPath1(root,arr1,p);
//         getPath2(root,arr2,q);
//         int idx1=1;
//         int idx2=1;
//         while(idx1<arr1.size() && idx2<arr2.size()){
//             if(arr1.get(idx1).equals(arr2.get(idx2))){
//                 ans=new TreeNode(arr1.get(idx1));
//             }
//             idx1++;
//             idx2++;
//         }
// return ans;
        
//     }
// }





//Optimal solution
class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null ||p==root || q==root){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);


        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
     }
}