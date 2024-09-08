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
    int count = 0;
    int result;
    public int kthSmallest(TreeNode root, int k) {
    //    TreeNode ans = helper(root,k);
    //    return ans==null ? null : ans.val;
        helper(root,k);
        return result;
    }

    // public TreeNode helper(TreeNode root, int k){
    //     if(root==null){
    //         return root;
    //     }

    //     TreeNode left = helper(root.left, k);
    //     if(left!=null){
    //         return left;
    //     }
    //     count++;
    //     if(count==k){
    //         return root;
    //     }

    //     return helper(root.right, k);
    // }

    public void helper(TreeNode root, int k){
        if(root==null){
            return;
        }

        helper(root.left,k);
        count++;
        if(count==k){
            result = root.val;
            return;
        }
        helper(root.right,k);
    }
}