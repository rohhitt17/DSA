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
    class pair{
        TreeNode node;
        int index;
        pair( TreeNode node,int index){
           this.node =node;
            this.index =index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<pair> pq=new LinkedList<>();
        pq.offer(new pair(root,0));
        int maxwidht=0;
        while(!pq.isEmpty()){
            int size=pq.size();
            int minIndex=pq.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                pair curr=pq.poll();
               int currindex=curr.index-minIndex;
                if(i==0)first=currindex;
                if(i==size-1)last=currindex;
                if(curr.node.left!=null){
                    pq.offer(new pair(curr.node.left,2*currindex));
                }
                   if(curr.node.right!=null){
                    pq.offer(new pair(curr.node.right,2*currindex+1));
                }
                maxwidht=Math.max(maxwidht,last-first+1);

            }
           
        }
          return maxwidht;
    }
}