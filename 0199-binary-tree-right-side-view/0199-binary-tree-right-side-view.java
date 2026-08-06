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
    public List<Integer> rightSideView(TreeNode root) {
    //     if (root == null) {
    //         return 0;

    //     }
    //     Queue<TreeNode> q = new LinkedList<>();
    //     ArrayList<Integer> list = new ArrayList<>();
    //     ArrayList<Integer> right = new ArrayList<>();

    //     q.add(root);
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         ArrayList<Integer> level = new ArrayList<>();

    //         for (int i = 0; i < size; i++) {
    //             if (root.right != null) {
    //                 q.add(root.right);
    //             }
    //             if (root.left != null) {
    //                 q.add(root.left);
    //             }

    //         }
    //         level.add(q.peek());
    //     }

    // }

    // public int view(TreeNode root, int level) {
    //     TreeNode node = root;
    //     if (root == null) {
    //         return 0;
    //     }
    //     view(node.right, level + 1);
    //     view(node.left, level + 1);

    Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<Integer> res=new ArrayList<>();
        if(root==null){
                return res;
            }
        q.offer(root);
      
                while(!q.isEmpty()){
            ArrayList<Integer> level=new ArrayList<>();
              int size=q.size();
            for(int i=0;i<size;i++){
                
                TreeNode node=q.poll();
                level.add(node.val);
                

                
                if(node.right!=null){
                    q.offer(node.right);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
            }
            res.add(level.get(0));
        }
        return res;

    }
}