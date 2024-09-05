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
    public int sumOfLeftLeaves(TreeNode root) {
        return calculateSum(root,false);
    }

    public int calculateSum(TreeNode node, boolean flag){
        if(node==null){
            return 0;
        }

        if(flag && node.left==null && node.right==null){
            return node.val;
        }

        return calculateSum(node.left,true) + calculateSum(node.right,false);
    }
}