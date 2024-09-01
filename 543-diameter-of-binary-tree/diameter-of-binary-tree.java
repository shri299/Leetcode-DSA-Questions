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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
        
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int dia1 = leftHeight + rightHeight;
        dia = Math.max(dia,dia1);
        return Math.max(leftHeight,rightHeight)+1;
    }
}