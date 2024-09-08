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
    // int count = 0;
    // int result;

    int ans;

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {
    //    TreeNode ans = helper(root,k);
    //    return ans==null ? null : ans.val;

        // helper(root,k);
        // return result;

        helper(root,queue);

        for(int i=0;i<k;i++){
            ans = queue.poll();
        }

        return ans;

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

    //2nd method

    // public void helper(TreeNode root, int k){
    //     if(root==null){
    //         return;
    //     }

    //     helper(root.left,k);
    //     count++;
    //     if(count==k){
    //         result = root.val;
    //         return;
    //     }
    //     helper(root.right,k);
    // }

    //3rd method -> use priority queue, array etc

    public void helper(TreeNode root, PriorityQueue<Integer> queue){
        if(root==null){
            return;
        }

        helper(root.left,queue);
        queue.offer(root.val);
        helper(root.right,queue);
    }
}