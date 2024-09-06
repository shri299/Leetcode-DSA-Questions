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
    List<Integer> sortedArray = new ArrayList<>();
    int minVal = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        //inorder traverse and convert to sorted array
        inorder(root);

        //then calculate the minimum  
        for(int i=0;i<sortedArray.size()-1;i++){
            int diff = sortedArray.get(i+1) - sortedArray.get(i);
            minVal = Math.min(diff,minVal);
        }

        return minVal;
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }

        inorder(root.left);
        sortedArray.add(root.val);
        inorder(root.right);
    }
}