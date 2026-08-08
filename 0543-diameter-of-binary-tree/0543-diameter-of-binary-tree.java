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

//  Brute force approach not optimal 
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {

//         if (root == null) {
//             return 0;
//         }
//         int lh = ht(root.left);
//         int rh = ht(root.right);

//         int leftdia = diameterOfBinaryTree(root.left);
//         int rightdia = diameterOfBinaryTree(root.right);
//         return Math.max(lh + rh, Math.max(leftdia, rightdia));

//     }

//     public int ht(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int leftht = ht(root.left);
//         int rightht = ht(root.right);
//         return 1 + Math.max(leftht, rightht);
//     }
// }

// Optimal approach O(N)
class Solution {

    int maxi = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ht(root);
        return maxi;
    }

    public int ht(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = ht(root.left);
        int rh = ht(root.right);

        maxi = Math.max(maxi, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}

