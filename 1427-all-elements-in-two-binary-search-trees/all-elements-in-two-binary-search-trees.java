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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ll=new ArrayList<>();
           AllElements(root1,ll);
            AllElements(root2,ll);
           Collections.sort(ll);
           return ll;
    }
     private void AllElements(TreeNode root,List<Integer>ll) {
       if(root==null){
        return;
       }
       AllElements(root.left,ll);
        ll.add(root.val);
          AllElements(root.right,ll);
    }
}