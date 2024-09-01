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
    TreeNode root;

    public TreeNode sortedArrayToBST(int[] nums) {
        insertSorted(nums,0,nums.length);
        return root;
    }

    public void insertSorted(int[] nums, int start, int end){
        if (start>=end){
            return;
        }
        int mid = (start + end)/2;

        this.insert(nums[mid]);
        insertSorted(nums,start,mid);
        insertSorted(nums,mid+1,end);
    }

    public void insert(int val){
        root = insert(val,root);
    }

    public TreeNode insert(int val, TreeNode node){
        if (node==null){
            return new TreeNode(val);
        }
        if (val<node.val){
            node.left=insert(val,node.left);
        }
        if (val>node.val){
            node.right=insert(val,node.right);
        }

        return node;

    }
}