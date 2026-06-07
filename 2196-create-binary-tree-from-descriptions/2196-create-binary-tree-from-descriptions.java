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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();

        for(int[] d:descriptions){
            int parent=d[0];
            int child=d[1];
            int isleft=d[2];
            map.putIfAbsent(parent,new TreeNode(parent));
            map.putIfAbsent(child,new TreeNode(child));

            if(isleft==1){
                map.get(parent).left=map.get(child);
            }
            else{
                map.get(parent).right=map.get(child);
            }
        }


        for(int nodeval: map.keySet()){
            boolean hasparent=false;

            for(int[] d: descriptions){
                if(d[1]==nodeval){
                    hasparent=true;
                    break;
                }
            }
            if(!hasparent){
                return map.get(nodeval);
            }
        }
        return null;
        
    }
}