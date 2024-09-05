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
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        helper(root,root.val);
        return flag;
    }

    public void helper(TreeNode root, int target){
        if(root==null){
            return;
        }
        if(root.val!=target){
            flag = false;
        }
        if(!flag)
        {
            return;
        }
        helper(root.left,target);
        helper(root.right,target);
    }
}