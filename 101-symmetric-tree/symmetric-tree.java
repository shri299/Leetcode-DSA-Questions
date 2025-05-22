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
    boolean ans = true;
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        helper(root.left,root.right);
        return ans;
    }

    private void helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return;
        if((left==null && right!=null) || (left!=null && right==null)){
            ans = false;
            return;
        }
        if(left.val!=right.val){
            ans = false;
            return;
        }
        helper(left.left,right.right);
        helper(left.right,right.left);
    }
}