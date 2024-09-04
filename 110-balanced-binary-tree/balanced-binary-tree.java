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
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null)  return true;
// 		if (Height(root) == -1)  return false;
// 		return true;
// 	}
  
// 	public int Height(TreeNode root) {
// 		if (root == null)  return 0;
        
// 		int leftHeight = Height(root.left);
        
// 		int rightHight = Height(root.right);
        
// 		if (leftHeight == -1 || rightHight == -1)  return -1;
        
//         if (Math.abs(leftHeight - rightHight) > 1)  return -1;
        
// 		return Math.max(leftHeight, rightHight) + 1;
//     }
// }


class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }
    public int height(TreeNode node){
        if(node == null) return -1;
        int left = height(node.left);
        int right = height(node.right);
        int diff = Math.abs(left - right);
        if(diff > 1)
            flag = false;
        return 1 + Math.max(left, right);
    }
}