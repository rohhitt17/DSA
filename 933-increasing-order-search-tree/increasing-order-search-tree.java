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
    TreeNode prev = null;
    TreeNode newRoot = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Process current node
        if (prev == null) {
            newRoot = node;  // first node (smallest)
        } else {
            prev.right = node;
        }
        node.left = null;   // remove left link
        prev = node;

        inorder(node.right);
    }
}