/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void make(TreeNode root, Map<TreeNode, TreeNode> parent, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {

                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {

                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        make(root, parent, target);
        
        int distance = 0;
        q.offer(target);
        visited.put(target, true);
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) {
                break;
            }
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }
                if (parent.get(curr) != null && visited.get(parent.get(curr)) == null) {
                    visited.put(parent.get(curr), true);
                    q.offer(parent.get(curr));

                }
            }
        }
ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            list.add(curr.val);

        }
        return list;
    }
}