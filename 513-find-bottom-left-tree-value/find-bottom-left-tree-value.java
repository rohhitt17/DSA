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
    int maxdepth=-1;
    int result=0;
    public int findBottomLeftValue(TreeNode root) {
        BottomLeftValue(root,0);
       return  result;
    }
    public void BottomLeftValue(TreeNode root,int depth) {
        if(root==null){
            return ;
        }
        if(depth>maxdepth){
            maxdepth=depth;
            result=root.val;
           }
        BottomLeftValue(root.left,depth+1);
         BottomLeftValue(root.right,depth+1);
    }

}