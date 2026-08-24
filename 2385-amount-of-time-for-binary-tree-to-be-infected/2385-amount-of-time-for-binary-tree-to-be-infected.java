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
    public TreeNode make(TreeNode root,Map<TreeNode,TreeNode>parent,int start){
        Queue<TreeNode> q=new LinkedList<>();
        
        q.offer(root);
        TreeNode target = null;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
             if (curr.val == start) {
                target = curr;
            }
            
            if(curr.left!=null){
                
                parent.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode>q=new LinkedList<>();
         Map<TreeNode,TreeNode>parent=new HashMap<>();
       Set<TreeNode> visited = new HashSet<>();
        TreeNode target = make(root, parent, start);
    
        int time=0;
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
             boolean burnedNewNode = false;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(parent.get(curr.left)!=null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                    burnedNewNode=true;
                }
                if(parent.get(curr.right)!=null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                    burnedNewNode=true;
                }
                TreeNode par = parent.get(curr);
                if (par != null && !visited.contains(par)) {
                    q.offer(par);
                    visited.add(par);
                    burnedNewNode = true;
                }
                
            }
            if(burnedNewNode==true){
                    time++;
                }
        }
        return time;

        
    }
}